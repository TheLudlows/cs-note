1. hashmap resize 优化
   因此，我们在扩充HashMap的时候，不需要像JDK1.7的实现那样重新计算hash，
   只需要看原来的hash值在扩容后新增的那一位是1还是0，如果是0的话索引没变，是1的话索引变成“原索引+oldCap” 
   扩容循环链表 头插法 尾插法
2. LinkedHashMap
    LRU 双链表
   按插入顺序排序（当 accessOrder = false） 按最近获取的数据倒序（当 accessOrder = true）
   
3. synchronized
-todo
   
4. CopyOnWriteArrayList
 适用于写少读多的场景

https://www.nowcoder.com/discuss/356120
https://blog.csdn.net/weixin_53170684/article/details/112563450
https://zhuanlan.zhihu.com/p/150659982