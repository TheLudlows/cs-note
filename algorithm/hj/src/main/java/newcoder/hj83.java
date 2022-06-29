package newcoder;

import java.util.Scanner;

public class hj83 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(0);
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            if(x1<x && x2<x && y1<y && y2<y) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            int addx = scanner.nextInt();
            if(addx>=0 && addx < x) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            int addy = scanner.nextInt();
            if(addy>=0 && addy < y-1) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            int xf = scanner.nextInt();
            int yf = scanner.nextInt();

            if(xf<x && xf<x && yf<y && yf<y) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }
}
