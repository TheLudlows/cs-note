package io.four;

/**
 * 归并排序(Merge Sort)也是一种Divide and Conquer算法。它将输入数组分为两半，为两半调用自身，然后合并两个已排序的一半
 */
public class MergeSort {

    public static void sort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int mid = left + right / 2;

        sort(arr,left,mid);
        sort(arr,mid+1,right);

        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int k = 0;
        int p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R)
            help[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];  //左右两边相等的话，就先拷贝左边的(实现稳定性)
        while (p1 <= mid)  //左边剩余的部分
            help[k++] = arr[p1++];
        while (p2 <= R)   //右边剩余的部分
            help[k++] = arr[p2++];
        for (int i = 0; i < k; i++) //拷贝回原来的数组
            arr[i + L] = help[i];
    }
}
