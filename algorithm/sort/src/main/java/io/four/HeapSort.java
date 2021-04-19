package io.four;

import java.util.Arrays;

import static io.four.QuickSort.swap;

public class HeapSort {

    private static void heapSort(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            swap(arr, 0, i);
            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int parent, int len) {
        if (parent >= len) {
            return;
        }
        int max = parent;
        int c1 = 2 * parent + 1;
        int c2 = 2 * parent + 2;

        if (c1 < len && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < len && arr[c2] > arr[max]) {
            max = c2;
        }
        if(max != parent) {
            swap(arr,parent, max);
            adjustHeap(arr, max, len);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,4,8,5,9,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
