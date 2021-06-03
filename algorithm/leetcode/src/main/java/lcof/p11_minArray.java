package lcof;

public class p11_minArray {

    public static int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int mid = (l + r) >> 1;
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return numbers[l];
    }

    public static int searchInsert(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = r + l >> 1;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        searchInsert(new int[]{1, 3, 5, 6}, 2);
    }
}
