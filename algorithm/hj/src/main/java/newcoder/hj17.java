package newcoder;

import java.util.Scanner;

public class hj17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arr = line.trim().split(";");
        int x = 0;
        int y = 0;
        for(String s : arr) {
            if(s.length() < 2) {
                continue;
            }
            s = s.toLowerCase();
            try {
                char dir = s.charAt(0);
                int n =  Integer.parseInt(s.substring(1));
                if(dir == 'a') {
                    x -= n;
                } else if(dir == 'd') {
                    x +=n;
                } else if(dir == 'w') {
                    y +=n;
                } else if(dir == 's') {
                    y-=n;
                }
            }catch(Exception e) {
                continue;
            }
        }

        System.out.println(x+"," + y);
    }
}
