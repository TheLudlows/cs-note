package hj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hj10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        Set<Character> ser = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            ser.add(str.charAt(i));
        }
        System.out.println(ser.size());
    }
}
