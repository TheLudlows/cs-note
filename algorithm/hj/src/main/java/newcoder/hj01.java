package newcoder;

import java.util.Scanner;

public class hj01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arr = line.trim().split(" ");
        System.out.println(arr[arr.length - 1].length());
    }
}
