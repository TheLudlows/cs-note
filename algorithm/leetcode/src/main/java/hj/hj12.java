package hj;

import java.util.Scanner;

public class hj12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        for(int i=str.length()-1;i>=0;i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
}
