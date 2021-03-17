package io.four;

import java.util.Arrays;

import static io.four.QuickSort.swap;

/**
 * 冒泡排序O（n ^ 2）,优化:针对有序集合，如果再一次的冒泡中没有交换任何一个元素，则直接跳出外部循环，因为集合已经有序。
 */
public class BubbleSort {

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
            if (isBreak) {
                break;
            }
        }
        return arr;
    }

    /**
     * 递归实现
     */
    public static void bubbleSort(int arr[], int n) {
        if (n == 1)
            return;
        for (int i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

        bubbleSort(arr, n - 1);
    }

    public static void cocktailSort(int arr[]) {
        int L = 0, R = arr.length - 1;
        while (L < R) {
            for (int i = L; i < R; i++) if (arr[i] > arr[i + 1]) swap(arr, i, i + 1);
            R--;
            for (int i = R; i > L; i--) if (arr[i] < arr[i - 1]) swap(arr, i, i - 1);
            L++;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,4,3,5};
        cocktailSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
