package io.four;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
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

    public static void main(String[] args) {
        int arr[] = new int[]{3,2,0,1,100,33};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
