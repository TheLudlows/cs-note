package hj;

import java.util.Scanner;

public class hj13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        String[] arr = str.split(" ");
        for(int i=arr.length-1;i>=0;i--) {
            System.out.print(arr[i]);
            if(i != 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
