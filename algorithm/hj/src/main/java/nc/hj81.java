package nc;

import java.util.Scanner;

public class hj81 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String l1 = scanner.nextLine();
            String l2 = scanner.nextLine();

            int[] map = new int[256];

            for(int i=0;i<l2.length();i++) {
                map[l2.charAt(i)] ++;
            }

            boolean flag = true;
            for(int i=0;i<l1.length();i++) {
                if(map[l1.charAt(i)] == 0) {
                    System.out.println("false");
                    flag = false;
                    break;
                } else {
                    //map[l1.charAt(i)] --;
                }
            }
            if(flag) {
                System.out.println("true");
            }

        }
    }
}
