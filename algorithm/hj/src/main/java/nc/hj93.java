package nc;

import java.util.Scanner;

public class hj93 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            scanner.nextLine().trim();
            String[] strArr = scanner.nextLine().trim().split(" ");
            int[] arr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }
            System.out.println(div(arr));
        }
    }

    public static boolean div(int[] arr) {
        int sum3 = 0;
        int sum5 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0) {
                sum3 += arr[i];
            } else if (arr[i] % 5 == 0) {
                sum5 += arr[i];
            }
        }
        return dfs(arr, sum3, sum5, 0);
    }

    public static boolean dfs(int[] arr, int sum3, int sum5, int idx) {
        if (idx == arr.length) {
            return sum3 == sum5;
        }
        if (arr[idx] % 3 != 0 && arr[idx] % 5 != 0) {
            return dfs(arr, sum3 + arr[idx], sum5, idx + 1) ||
                    dfs(arr, sum3, sum5 + arr[idx], idx + 1);
        } else {
            return dfs(arr, sum3, sum5, idx + 1);
        }
    }
}


