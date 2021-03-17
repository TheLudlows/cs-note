package io.four;

/**
 * 选择排序，待排序的集合分为两部分，有序集合和无序集合，在无序集合中寻找最小的添加到有序集合的尾部
 */
public class SelectionSort {

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

    public static void main(String[] args) {
        System.out.println(sort(new int[]{1,3,2,6,4}));
    }
}
