package newcoder;

import java.util.Scanner;

public class hj55 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n  = scanner.nextInt();
            int total = 0;
            for(int i=1;i<=n;i++) {
                if(i % 7 == 0) {
                    total++;
                    continue;
                }
                int j = i;
                while(j > 0) {
                    if(j % 10 == 7) {
                        total++;
                        break;
                    }
                    j = j /10;
                }
            }
            System.out.println(total);
        }
    }
}
