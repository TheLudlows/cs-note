import com.sun.org.apache.xpath.internal.operations.String;

import java.util.PriorityQueue;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("111111");

            }
        });
        t.start();
        t.interrupt();
        System.out.println(1);
        StringBuffer buffer = new StringBuffer();
        PriorityQueue queue = new PriorityQueue();
    }


}
