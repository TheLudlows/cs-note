package lcof;

import java.util.Scanner;

public class MaxSum {
    private static int res = -1;
    private static int target = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.parseInt(s);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        max(arr);
    }


    public static void max(int[] price) {
        recur(price, 0, 0);
        System.out.println(res);
    }

    private static void recur(int[] nums, int cur, int sum) {
        if (cur <= nums.length) {
            if (sum % target == 0) {
                res = Math.max(sum, res);
            }
            // 选择
            if(cur ==  nums.length) {
                return;
            }
            recur(nums, cur + 1, sum + nums[cur]);
            // 不选择
            recur(nums, cur + 1, sum);
        }
    }
}
