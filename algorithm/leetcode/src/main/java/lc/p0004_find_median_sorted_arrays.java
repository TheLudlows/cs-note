package lc;

import java.util.Arrays;

public class p0004_find_median_sorted_arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] new_arr = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0; // new array idx

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                new_arr[k] = nums1[i];
                i++;
            } else {
                new_arr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            new_arr[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            new_arr[k++] = nums2[j++];
        }
        System.out.println(Arrays.toString(new_arr));
        int len = new_arr.length;
        return (new_arr[len / 2] + new_arr[(len - 1) / 2]) / 2.0;
    }
}
