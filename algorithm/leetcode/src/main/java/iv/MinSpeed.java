package iv;

import java.util.Scanner;

public class MinSpeed {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine().trim();
            if (s.equals("") || s.equals("\n")) {
                System.out.println(-1);
                return;
            }
            String[] arr = s.split(" ");
            if (arr.length <= 1) {
                System.out.println(-1);
                return;
            }
            int h = Integer.valueOf(arr[arr.length - 1]);
            int[] nums = new int[arr.length - 1];

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length - 1; i++) {
                nums[i] = Integer.valueOf(arr[i]);
                min = Math.min(nums[i], min);
                max = Math.max(max, nums[i]);
            }

            for (int i = min; i <= max; i++) {
                int need = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] % i == 0) {
                        need += nums[j] / i;
                    } else {
                        need += nums[j] / i + 1;
                    }
                }
                if (need <= h) {
                    System.out.println(i);
                    return;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(-1);
        }
    }
}
