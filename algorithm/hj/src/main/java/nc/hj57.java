package nc;

import java.util.Scanner;

public class hj57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String l1 = scanner.nextLine();
            String l2 = scanner.nextLine();

            if(l1.length() < l2.length()) {
                String l = l1;
                l1 = l2;
                l2= l;
            }

            while(l1.length() > l2.length()) {
                l2 = "0" + l2;
            }

            System.out.println(l1);
            System.out.println(l2);

            int flow = 0;
            StringBuilder builder = new StringBuilder();
            for(int i= l1.length()-1;i>=0;i--) {
                int c1 = l1.charAt(i) - '0';
                int c2 = l2.charAt(i) - '0';
                int res = c1 + c2 + flow;
                if(res <= 9) {
                    builder.append((char)('0' + res));
                    flow = 0;
                } else {
                    builder.append((char)('0' + res - 10));
                    flow = res%10;
                }
            }
            if(flow > 0) {
                builder.append((char)('0' + flow));
            }
            System.out.println(builder.reverse());
        }
    }
}
