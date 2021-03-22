package io.four;

import java.util.Arrays;

/**
 * 快排
 * <l>https://images2015.cnblogs.com/blog/996996/201607/996996-20160726194324778-90106537.png</l>
 */
public class QuickSort {
    public static void quickSortHelp(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }

    }

    public static int partition(int[] arr, int low, int high) {
        int index = low + 1;
        int pivot = low;
        int p = arr[low];
        for (int i = low; i <= high; i++) {
            if (arr[i] < p) {
                swap(arr, index++, i);  //满足条件交换位置，且index向右移动
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }


    public int par(Integer[] list, int l, int r) {
        int p = list[l];    //数组的第一个作为中轴
        while (l < r) {
            while (l < r && list[r] >= p) {
                r--;
            }
            list[l] = list[r];   //比中轴小的记录移到低端
            while (l < r && list[l] <= p) {
                l++;
            }
            list[r] = list[l];   //比中轴大的记录移到高端
        }
        list[l] = p;              //中轴记录到尾
        return l;                   //返回中轴的位置
    }


    public static void swap(int[] arr, int high, int low) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static void main(String[] args) {
        int[] array = {2, 8, 5, 6, 10, 5, 4, 6, 11, 15, 3};
        quickSortHelp(array);
        System.out.println(Arrays.toString(array));
    }
}
