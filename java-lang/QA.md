1. hashmap resize 优化
   因此，我们在扩充HashMap的时候，不需要像JDK1.7的实现那样重新计算hash，
   只需要看原来的hash值在扩容后新增的那一位是1还是0，如果是0的话索引没变，是1的话索引变成“原索引+oldCap” 
   扩容循环链表 头插法 尾插法
2. LinkedHashMap
    LRU 双链表
   按插入顺序排序（当 accessOrder = false） 按最近获取的数据倒序（当 accessOrder = true）
   
3. synchronized
    - 对象头 标记字段 、class pointer 、[数组长度]
        - GC年龄
        - 持有的锁
        - 偏向线程ID
    - 实例数据
    - 填充数据
    
 偏向锁  偏向标记 偏向线程ID 被其他线程访问才会撤销锁。

 轻量级锁   CAS 获取轻量级锁  
 当线程的自旋次数过长依旧没获取到锁，为避免CPU无端耗费，锁由轻量级锁升级为重量级锁
   
4. CopyOnWriteArrayList
 适用于写少读多的场景
   
5. 线程池入队的时机，拒绝策略。直接拒绝，rejectException，丢弃任务不抛异常。
6. CAS ABA问题，AtomicStampedReference 版本号解决
7. ReentrantLock/ AQS
 状态标志 队列 入队 公平 head 节点
   
8. CyclicBarrier CountDownLatch
9. ThreadLocal

https://www.nowcoder.com/discuss/356120
https://blog.csdn.net/weixin_53170684/article/details/112563450
https://zhuanlan.zhihu.com/p/150659982