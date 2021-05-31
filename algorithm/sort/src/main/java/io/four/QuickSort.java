package io.four;

import java.util.Arrays;

/**
 * 快排
 * <l>https://images2015.cnblogs.com/blog/996996/201607/996996-20160726194324778-90106537.png</l>
 */
public class QuickSort {
    public static void quickSortHelp(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    public static void qs(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 找到中枢
        int p = partition(arr, l, r);
        qs(arr, l, p - 1);
        qs(arr, p + 1, r);
    }

    public static int partition(int arr[], int l, int r) {
        int p = l;
        l += 1;
        while (l <= r) {
            if (arr[l] > arr[p]) {
                swap(arr, r, l);
                r--;
            } else {
                l++;
            }
        }
        swap(arr, p, r);
        return r;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {2, 8, 5, 6, 10, 5, 4, 6, 11, 15, 3};
        quickSortHelp(array);
        System.out.println(Arrays.toString(array));
    }
}
