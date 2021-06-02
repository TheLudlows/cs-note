package hj;

import java.util.Scanner;

public class hj26 {


    // 冒泡排序
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int slow = 0;
                while (slow < chars.length && !isLetter(chars[slow])) {
                    slow++;
                }
                int fast = slow + 1;
                while (fast < chars.length - i) {
                    while (fast < chars.length - i && !isLetter(chars[fast])) {
                        fast++;
                    }
                    if(fast >= chars.length - i) {
                        break;
                    }
                    if (Character.toLowerCase(chars[fast]) < Character.toLowerCase(chars[slow])) {
                        swap(chars, slow, fast);
                    }
                    slow = fast;
                    fast += 1;
                }
            }
            System.out.println(new String(chars));
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
