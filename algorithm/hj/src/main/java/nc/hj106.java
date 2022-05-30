package nc;

import java.util.Scanner;

public class hj106 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            for(int i=0;i<arr.length;i++) {
                arr[i] = new StringBuilder(arr[i]).reverse().toString();
            }

            for(int i=arr.length-1;i>=0;i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
