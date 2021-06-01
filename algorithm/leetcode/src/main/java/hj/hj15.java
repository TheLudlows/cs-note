package hj;

import java.util.Scanner;

public class hj15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int count = 0;
        while(n != 0) {
            if( (n & 1) == 1) {
                count+=1;
            }
            n = n >> 1;
        }
        System.out.println(count);
    }
}
