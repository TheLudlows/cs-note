BitMap/BitSet被广泛的应用于数据查询中，但其由于数据稀疏造成的内存浪费也不可忽视，因此对压缩BitMap的探索一直在进行，比较知名的有WAH、EWAH、Roaring Bitmap等。其中性能最好并且应用最为广泛的当属Roaring Bitmap，比如Spark、Lucene、Redis、Influxdb等著名项目中都可以看到Roaring Bitmap身影，下面就谈谈Roaring Bitmap它是如何实现。

在传统的BitMap中，所有的Bit都放在一个Int或者Long数组中，在Roaring Bitmap中对数据的高16位进行分片，高16位相同的落入统一的分片中，每个分片大小相同，最多可容纳2^16个数。然后根据实际的数量情况选择合适的存储方式，这里的存储方式在Roaring Bitmap中称为容器（Container）。2^16个Bit为8kb，在Bitmap中一定占用8kb内存，但是假如一个片下只有一个数据，那么就没必要占用8kb了。再比如所有的数据都存在，即2^16个Bit全部位1，我们可以用(65536,1)来表示，只占用4byte。因此就有了三种不同的Container。

##### 1.  ArrayContainer

该容器适用于存储数量比较少的情况，同一个分片下高16位都相同，因此只需要记录低16位即可。ArrayContainer使用**有序**的char[]来保存数据，没错，就是保存数据的低16位，而不是bit。该数据初始容量为4，然后逐渐增大。因为数组时有序的，查找时通过二分法来检测该数据是否存在。当数组长度超过4096时，会转化为BitmapContainer。因为长度为4096已经占用了8kb，但是只能存储4096个值。
##### 2. BitmapContainer
该容器和普通的Bitmap一样，通过Long数组来保存65536个bit值，因此长度为1024，如果超过/缩小至阈值。BitmapContainer和ArrayContainer使用可以相互转化。
##### 3. RunContainer
RunContainer中的Run指的是行程长度压缩算法(Run Length Encoding)，对连续数据有比较好的压缩效果。用一个short[]来存储所有的数据。它的原理是，对于连续出现的数字，只记录初始数字和后续数量。比如：`1, 10, 20,0, 31,2 `表示`1, 2, ..., 11, 20, 31, 32, 33`。
只有当调用runOptimize()方法时，会比较和RunContainer的空间占用大小，选择是否转换为RunContainer。

##### 关于性能和内存
性能方面最出众的C++版本的Roaring Bitmap，比如SIMD加速位操作，当然这不是它独有的。个人认为主要还是它的内存占用，无论数据密集与否，都能有优于Bitmap。


