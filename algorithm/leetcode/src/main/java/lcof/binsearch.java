package lcof;


// todo
public class binsearch {

    // search insert
    public static int bin_find(int[] arr, int n) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > n) {
                r = mid - 1;
            } else if (arr[mid] < n) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }

    public static int bin_find_left(int[] arr, int n) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] < n) {
                r = mid + 1;
            } else {
                l = mid;
            }
        }
        if (arr[l] == n) {
            return l;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 3, 3, 3,5};
        System.out.println(bin_find(arr,4));
    }
}
