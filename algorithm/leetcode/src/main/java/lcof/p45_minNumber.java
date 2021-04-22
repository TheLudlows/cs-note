package lcof;

import java.util.Arrays;

public  class p45_minNumber {
    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (e1, e2) -> (e1 + e2).compareTo(e2 + e1));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arr) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println("01".compareTo("10"));
    }
}