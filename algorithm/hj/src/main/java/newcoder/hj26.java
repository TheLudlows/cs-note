package newcoder;

import java.util.Scanner;

public class hj26 {
    // 冒泡排序才是稳定算法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            StringBuilder builder = new StringBuilder();
            StringBuilder out = new StringBuilder();
            String line = scanner.nextLine().trim();
            char[] chars = line.toCharArray();
            for (int i = 0; i < 26; i++) {
                for(int j=0;j<chars.length;j++) {
                    if (chars[j] - 'a' == i || chars[j] - 'A' == i) {
                        builder.append(chars[j]);
                    }
                }
            }
            int j = 0;
            for (int i = 0; i < chars.length; i++) {
                if (isLetter(chars[i])) {
                    out.append(builder.charAt(j));
                    j++;
                } else {
                    out.append(chars[i]);
                }
            }
            System.out.println(out);
        }
    }

    public static boolean isLetter(char c) {
        return ('A' <= c && 'Z' >= c) || ('a' <= c && 'z' >= c);
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
