package newcoder;

import java.util.Scanner;

public class hj37 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = Integer.parseInt(scanner.nextLine());
            System.out.println(find(m));
        }
    }

    public static int find(int n) {
        if (n <= 2) {
            return 1;
        }
       return  find(n - 2) + find(n - 1);
    }
}

