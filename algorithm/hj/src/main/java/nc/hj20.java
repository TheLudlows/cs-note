package nc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hj20 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            if(!muti(line)) {
                System.out.println("NG");
                continue;
            }
            if (!right(line)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    // 字串全部加入set，三个加入
    static boolean right(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 3; i++) {
            String sub = s.substring(i,i+3);
            if (set.contains(sub)) {
                return false;
            } else {
                set.add(sub);
            }
        }
        return true;
    }

    static boolean muti(String s) {
        Set<Integer> set = new HashSet<>();
        for (int i =0 ;i<s.length();i++) {
            int asc = s.charAt(i);
            if(asc >=65 && asc <= 90) {
                set.add(1);
            } else if (asc>=97 && asc <=122) {
                set.add(2);
            } else if (asc<=57 && asc >=48) {
                set.add(3);
            } else {
                set.add(4);
            }
        }
        return set.size() >= 3;
    }
}
