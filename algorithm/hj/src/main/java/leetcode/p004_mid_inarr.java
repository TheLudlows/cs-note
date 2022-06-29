package leetcode;

public class p004_mid_inarr {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i++];
            } else {
                arr[k] = nums2[j++];
            }
            k++;
        }

        for (int c = i; c < nums1.length; c++) {
            arr[k++] = nums1[c];
        }

        for (int c = j; c < nums2.length; c++) {
            arr[k++] = nums1[c];
        }

        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        } else {
            return (arr[(arr.length - 1) / 2] + arr[arr.length / 2]) / 2.0;
        }
    }
}
