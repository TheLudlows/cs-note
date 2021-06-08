package iv;

import java.util.Arrays;

import static lcof.utils.swap;

public class TopKs {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 7, 0, 1};
        new TopKs().quickSort(arr, 0, arr.length - 1, 3);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right, int k) {

        if (left > right) {
            return;
        }
        int p = partition(arr, left, right);
        if (p == k - 1) {
            return;
        } else if (p > k-1) {
            quickSort(arr, left, p - 1, k);
        } else {
            quickSort(arr, p + 1, k-1, k);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int p = left;
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (arr[i] > arr[p]) {
                swap(arr,i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(arr, j, p);
        return j;
    }

}
