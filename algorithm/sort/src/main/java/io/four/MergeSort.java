package io.four;

import java.util.Arrays;

/**
 * 归并排序(Merge Sort)也是一种Divide and Conquer算法。它将输入数组分为两半，为两半调用自身，然后合并两个已排序的一半
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        System.out.println("left:" + left + " right:" + right);
        merge(arr, left, mid, right);
    }

    // 合并两个有序数组
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int k = 0;
        int p1 = l, p2 = mid + 1;
        while (p1 <= mid && p2 <= r)
            help[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];  //左右两边相等的话，就先拷贝左边的(实现稳定性)
        while (p1 <= mid)  //左边剩余的部分
            help[k++] = arr[p1++];
        while (p2 <= r)   //右边剩余的部分
            help[k++] = arr[p2++];
        System.arraycopy(help, 0, arr, l, help.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 2, 5};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
