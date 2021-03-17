package io.four;

import java.util.Arrays;

public class NetherlandsFlag {

    public static int[] partition(int[]arr, int num) {
        int left = -1;  //左边界的索引
        int right = arr.length;  //右边界的索引
        int cur = 0;  //当前位置的索引
        while(cur < right) {
            if(arr[cur] < num) {
                swap(arr, ++left, cur++);
            }else if(arr[cur] > num) {
                swap(arr, --right, cur);// cur不自加的原因是交换后的arr[cur]可能等于num，也可能小于，或者是大于，需要再做一次判断
            }else {
                cur++;
            }
        }
        return new int[] {left+1,right-1};
    }

    public static void swap(int [] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {23,4,2,5,7,42,4,34,32,7,8,39,45,63,21};
        int num = 34;
        partition(arr, num);
        sort(arr, num);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。
     */
    public static void sort(int[]arr,int num) {
        int index = -1;  //遍历数组从0开始，那么当前指针的左边界就是-1；
        for(int i=0;i<arr.length;i++) {
            if(arr[i]<=num) {
                swap(arr, ++index, i);  //满足条件交换位置，且index向右移动
            }else {
                continue;
            }
        }
    }
}