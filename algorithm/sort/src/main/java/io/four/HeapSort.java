package io.four;

import java.util.Arrays;

import static io.four.QuickSort.swap;

/**
 * 堆排序步骤
 * 1. 先把数组堆化，构建为一个大顶堆，此时堆顶为最大元素，交换最后一个元素和堆顶元素。继续构建堆。然后将堆的长度-1。
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 4, 8, 5, 9, 9};
        hs(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void hs(int[] arr) {
        // build tree
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            buildTree(arr, i, arr.length - 1);
        }
        System.out.println(Arrays.toString(arr));
        // move max to tail
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            buildTree(arr, 0, i - 1);
        }
    }

    public static void buildTree(int arr[], int idx, int len) {
        if (idx > len) {
            return;
        }
        int c1 = idx * 2 + 1;
        int c2 = idx * 2 + 2;

        int max_idx = idx;
        if (c1 <= len && arr[max_idx] < arr[c1]) {
            max_idx = c1;
        }
        if (c2 <= len && arr[max_idx] < arr[c2]) {
            max_idx = c2;
        }
        if (max_idx != idx) {
            swap(arr, max_idx, idx);
            buildTree(arr, max_idx, len);
        }
    }
}   
