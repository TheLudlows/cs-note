package hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hj09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        String str = scanner.nextLine();
        StringBuffer buf = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            int n = c - '0';
            if (!set.contains(n)) {
                set.add(n);
                buf.append(n);
            }
        }
        System.out.println(buf.toString());
    }

}
