package newcoder;

import java.util.Arrays;
import java.util.Scanner;

public class hj34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] cs = line.toCharArray();
            Arrays.sort(cs);
            System.out.println(new String(cs));
        }
    }
}
