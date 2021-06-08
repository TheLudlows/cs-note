1. hashmap resize 优化 因此，我们在扩充HashMap的时候，不需要像JDK1.7的实现那样重新计算hash，
   只需要看原来的hash值在扩容后新增的那一位是1还是0，如果是0的话索引没变，是1的话索引变成“原索引+oldCap” 扩容循环链表 头插法 尾插法
2. LinkedHashMap LRU 双链表 按插入顺序排序（当 accessOrder = false） 按最近获取的数据倒序（当 accessOrder = true）

3. synchronized
    - 对象头 标记字段 、class pointer 、[数组长度]
        - GC年龄
        - 持有的锁
        - 偏向线程ID
    - 实例数据
    - 填充数据

偏向锁 偏向标记 偏向线程ID 被其他线程访问才会撤销锁。

轻量级锁 CAS 获取轻量级锁  
当线程的自旋次数过长依旧没获取到锁，或第三个线程到来，为避免CPU无端耗费，锁由轻量级锁升级为重量级锁

4. CopyOnWriteArrayList 适用于写少读多的场景

5. 线程池入队的时机，拒绝策略。直接拒绝，rejectException，丢弃任务不抛异常。
6. CAS ABA问题，AtomicStampedReference 版本号解决
7. ReentrantLock/ AQS 状态标志 队列 入队 公平 head 节点

-- JMM 内存模型

8. CyclicBarrier CountDownLatch
9. ThreadLocal -> reference 弱引用 虚引用 Cleaner对象 虚引用，回收后会在后台添加队列时free

10.class loader

- Bootstrap classLoader:主要负责加载核心的类库(java.lang.*等)，构造ExtClassLoader和APPClassLoader。
- ExtClassLoader：主要负责加载jre/lib/ext目录下的一些扩展的jar。
- AppClassLoader：应用类加载器,又称为系统类加载器,负责在JVM启动时,加载来自在命令java中的classpath或者java.class.path系统属性或者CLASSPATH操作系统属性所指定的JAR类包和类路径.

首先会在AppClassLoader中检查是否加载过，如果有那就无需再加载了。如果没有，那么会拿到父加载器，然后调用父加载器的loadClass方法。父类中同理也会先检查自己是否已经加载过，如果没有再往上。注意这个类似递归的过程，直到到达Bootstrap
classLoader之前，都是在检查是否加载过，并不会选择自己去加载。直到BootstrapClassLoader，已经没有父加载器了，这时候开始考虑自己是否能加载了，如果自己无法加载，会下沉到子加载器去加载

11. IO模型 四种IO模型 重点多路复用
12. NIO reactor 
13.FULL GC young GC

14. 垃圾收集器 serial parnew parallel scavage serialold parold cms

15. GC调优

16.Spring 事务传播机制 事务失效 引擎、public、内部调用、相互依赖
https://zhuanlan.zhihu.com/p/98357492

17.Mysql Mysql调优  in 索引？

18. redis 缓存同步？雪崩 持久化 

19 netty
内存 内存分配算法、对象复用池、零拷贝、自定义ThreadLocal
IO IO多路复用、充分的利用Linux 的epoll 特性
线程 自定义线程 
高性能的数据结构 JDK性能的1.5倍
JDK空轮训的BUG 1.6 之前

20 设计模式

21 mybatis 一集缓存 session级别 sql语句相同，二级缓存 app级别 
22 限流算法 计数器  漏桶，请求进入桶中，匀速处理，可以用定去处理请求 令牌桶 匀速的产生令牌到桶里，请求每次去桶里获取，如果没有则等待。

21. 如何优化接口性能
  并行化、缓存 、缓存是否失效、数据库索引 GC(java)、算法层面优化

22 分布式数据库系统
   唯一ID的策略 
   分区策略 hash range  优劣 写的优势，ID自增和不自增的差别 点查询和范围查询
   数据副本一致性  raft

堆排 快排

todo
https://blog.csdn.net/oBuShanQing/article/details/86408091?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.baidujs&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.baidujs
https://zhuanlan.zhihu.com/p/357519584

拓展技巧，

todo
全局ID https://tech.meituan.com/2019/03/07/open-source-project-leaf.html
虚拟内存 https://www.cnblogs.com/panchanggui/p/9288389.html
https://zhuanlan.zhihu.com/p/150659982?from_voters_page=true