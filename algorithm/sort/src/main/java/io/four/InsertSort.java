package io.four;

/**
 * 插入排序
 */
public class InsertSort {

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

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,3,0};
        sort(arr);
        System.out.println();
    }
}
