package lcof;

public class p11_minArray {

    public static int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length-1;

        while (l < r) {
            int mid  = (l + r) >> 1;
            if(numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        minArray(new int[]{3,3,1,3});
    }
}
