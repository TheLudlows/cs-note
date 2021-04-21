#### 排序算法概述
- 排序算法分类

1. 比较排序，时间复杂度O(nlogn) ~ O(n^2)，主要有：冒泡排序，选择排序，插入排序，归并排序，堆排序，快速排序等。
2. 非比较排序，时间复杂度可以达到O(n)，主要有：计数排序，基数排序，桶排序等。

 - 稳定性

排序算法稳定性的简单形式化定义为：如果arr[i] = arr[j]，排序前arr[i]在arr[j]之前，排序后arr[i]还在arr[j]之前，则称这种排序算法是稳定的。通俗地讲就是保证排序前后两个相等的数的相对顺序不变。（可以通过自定义比较函数来去除稳定性问题）

#### 1. 冒泡排序
流程如下：
比较相邻的元素。如果第一个比第二个大，就交换他们两个。

对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。

针对所有的元素重复以上的步骤，除了最后一个。
```java
public int[] bubbleSort(int arr[]) {
    int n = arr.length;
    boolean isBreak;
    for (int i = 0; i < n - 1; i++) {
        isBreak = true;
        for (int j = 0; j < n - i - 1; j++)
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                isBreak = false;
            }
        if(isBreak) {
            break;
        }
    }
    return arr;
}
```
最好情况是遍历一次，所有的元素都为有序，即o(n),最坏情况n*(n-1)/2,o(n^2)

 - 鸡尾酒排序
 它的改进在于同时的冒泡两边，从低到高，然后从高到低；
```java
void cocktailSort(int[] arr) {
    int L = 0,R = arr.length-1;
    while(L < R) {
        for(int i = L; i < R; i++) if(arr[i] > arr[i+1]) swap(arr,i,i+1);
        R--;
        for(int i = R; i > L; i--) if(arr[i] < arr[i-1]) swap(arr,i,i-1);
        L++;
    }
}
```
#### 2. 选择排序
步骤
1. 首先在未排序序列中找到最小元素，存放到排序序列的起始位置
2. 再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
```java
public static int[] sort(int[] arr) {

    for (int i = 0; i < arr.length; i++) {
        int min_idx = i;
        for (int j = i + 1; j < arr.length; j++) {
            min_idx = arr[min_idx] > arr[j] ? j : min_idx;
        }
        int temp = arr[i];
        arr[i] = arr[min_idx];
        arr[min_idx] = temp;
    }
    return arr;
}
```
最好最坏情况都是o(n^2)
#### 3. 插入排序
算法步骤L：
1. 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
2. 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
```java
public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int cur = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > cur) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j+1] = cur;
    }
}
```
最好的情况是当集合有序，所有元素都不用移动，这里有个优化点，在向有序集合中插入元素时采用二分查找的方式，上面代码是遍历有序集合，直到找到合适的位置。
```java
public static void insertSort(int[] arr) {
    for(int i = 1; i < arr.length; i++) {
        int cur = arr[i];
        int L = 0, R = i-1;
        while(L <= R) {
            int mid = L + (R-L)/2;
            if(arr[mid] > key)R = mid - 1;
            else L = mid + 1;
        }
        //二分结束之后　L = 刚好大于key(不是等于)的那个位置
        for(int j = i-1; j >= L; j--)arr[j+1] = arr[j];
        arr[L] = key;
    }
}
```

#### 4. 希尔排序
希尔排序可以看作是插入排序的增强版，把集合分成几块，每一块进行一个插入排序，并且块逐渐变大直到与集合相同大小。
```java
static int sort(int arr[]) {
    int n = arr.length;

    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i += 1) {
            int temp = arr[i];
            int j;
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                arr[j] = arr[j - gap];
            arr[j] = temp;
        }
    }
    return 0;
}
```

#### 5. 快排
算法步骤：

 - 从数列中挑出一个元素，称为基准(pivot）;
 - 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 - 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 
 代码地址 -> [快排实现](src/main/java/io/four/QuickSort.java)
#### 6. 归并排序
算法流程

1. 将大集合排序分为多个小集合的排序，直到小集合中只有一个元素。
2. 准备一个额外的数组，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
3. 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
4. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
5. 重复步骤4直到某一指针达到序列尾；
6. 将另一序列剩下的所有元素直接复制到合并序列尾；

 代码地址 -> [归并排序实现](src/main/java/io/four/MergeSort.java)
 
 #### 7. 堆排序
 算法步骤
 1. 调整数组成为大顶堆
 2. 把堆顶元素和堆尾元素互换
 3. 无序区的个数减1,有序区加1，重复步骤1。直到无序区个数为1或者有序区的元素个数为数组的长度。
  
代码地址 -> [堆排序](src/main/java/io/four/HeapSort.java)


三路快排 基数排序
