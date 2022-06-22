package lcof;

import java.util.Arrays;

public class p51_rev {
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return  total;
    }

    int total = 0;
    private void mergeSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);

        // sort 有序数据组
        sort(nums, l, r, mid);
    }

    private void sort(int[] nums, int l, int r, int mid) {
        int i = l;
        int j = mid+1;
        int[] tmp = new int[r - l + 1];
        int k = 0;
        while(i <= mid && j <=r) {
            if(nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                total += mid - i + 1;
                tmp[k++] = nums[j++];
            }
        }

        while(i<=mid) {
            tmp[k++] = nums[i++];
        }
        while(j<=r) {
            tmp[k++] = nums[j++];
        }
        System.arraycopy(tmp, 0, nums, l, tmp.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,6,8};
        new p51_rev().mergeSort(arr, 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
