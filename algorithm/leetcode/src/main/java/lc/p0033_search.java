package lc;

import java.sql.Array;

// [4578 123]

// 首先判断有序的那段在哪，前半度或者后半段，如何区分，mid和left 或right比较。
// 在有序的那段中用target比较头尾，是否在有序的区间中，四种情况分别判断。
public class p0033_search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + right >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        new p0033_search().search(arr, 1);
    }
}
