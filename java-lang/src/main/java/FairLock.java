
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

@SuppressWarnings("Duplicates")
public class FairLock implements Lock {

    private final Queue queue = new Queue();
    private final AtomicInteger reentrantTimes = new AtomicInteger(0);
    private Thread owner;

    public void lock() {
        if (owner == Thread.currentThread()) {
            // reentrant
            reentrantTimes.incrementAndGet();
            return;
        }
        ByteBuffer.allocateDirect()
        // 公平锁，每个线程都入队，非公平这里直接修改reentrantTimes，如果失败再入队
        Node node = new Node(Thread.currentThread());
        Node pre = queue.enqueue(node);
        if (pre != queue.head.get() || reentrantTimes.get() != 0) {
            LockSupport.park(this);
        }
        gottenLock(pre, node);
    }

    // 得到锁，将head 指向当前node，覆盖掉head之前的node，简短
    private void gottenLock(Node pre, Node node) {
        owner = Thread.currentThread();
        node.clearThread();
        queue.head.set(node);
        reentrantTimes.set(1);
        // help GC
        node.pre.set(null);
        pre.next.set(null);
    }

    public void unlock() {
        if (owner != Thread.currentThread()) {
            throw new IllegalStateException("not the thread holding lock");
        }
        int rt = reentrantTimes.get();
        if (rt < 1) {
            throw new IllegalStateException("reentrant times < 1 when try to unlock");
        }
        if (rt > 1) {
            reentrantTimes.set(rt - 1);
            return;
        }
        // rt == 1
        owner = null;
        reentrantTimes.set(0);

        Node node = queue.head.get();
        // 唤醒下一个node
        Node next = queue.findNext(node);
        if (next != null) {
            LockSupport.unpark(next.thread.get());
        }
    }

    @SuppressWarnings("Duplicates")
    private static class Queue {
        final AtomicReference<Node> head;
        final AtomicReference<Node> tail;

        Queue() {
            Node sentinel = new Node();
            head = new AtomicReference<>(sentinel);
            tail = new AtomicReference<>(sentinel);
        }


        Node enqueue(Node node) {
            Node t;
            while (true) {
                t = tail.get();
                node.pre.lazySet(t);
                if (tail.compareAndSet(t, node)) {
                    t.next.set(node);
                    return t;
                }
            }
        }

        // AQS尾部开始寻找，因为入队时，新节点先设置新节点的pre，如果当前节点的下个节点为空或者已取消，那么尾部开始找第一个没取消的node
        Node findNext(Node node) {
            Node n = node.next.get();
            if (n != null) {
                return n;
            }
            // find node from tail
            Node c = tail.get();
            while (c != node) {
                n = c;
                c = c.pre.get();
            }
            return n;
        }
    }

    private static class Node {
        final AtomicReference<Thread> thread;
        final AtomicReference<Node> pre = new AtomicReference<>();
        // 这里是AQS中的优化,
        final AtomicReference<Node> next = new AtomicReference<>();

        Node() {
            this(null);
        }

        Node(Thread thread) {
            this.thread = new AtomicReference<>(thread);
        }

        void clearThread() {
            thread.set(null);
        }
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException();
    }

    static Integer n = 0;
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new FairLock();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    lock.lock();
                    n += 1;
                    lock.unlock();
                }
            });
            ts.add(t);
            t.start();
        }

        for (Thread t : ts) {
            t.join();
        }

        System.out.println(n);
    }
}
