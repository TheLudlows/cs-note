package newcoder;

import java.util.Scanner;

public class hj63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int n = scanner.nextInt();
            char[] chars = line.toCharArray();
            int max = 0;
            int start = 0;
            for (int i = 0; i < n; i++) {
                if (chars[i] == 'C' || chars[i] == 'G') {
                    max++;
                }
            }
            int r = max;
            for (int i = n; i < chars.length; i++) {
                if (chars[i] == 'C' || chars[i] == 'G') {
                    r++;
                }
                if (chars[i - n] == 'C' || chars[i - n] == 'G') {
                    r--;
                }
                if (r > max) {
                    start = i-n + 1;
                    max = r;
                }
            }
            System.out.println(line.substring(start, start + n));
        }


    }
}