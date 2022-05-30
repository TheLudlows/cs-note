package nc;

import java.util.Scanner;

public class hj04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            builder.append(s);
            while (builder.length() % 8 != 0) {
                builder.append('0');
            }
            int start = 0;
            int end;
            while (builder.length() > start) {
                end = start + 8;
                String out = builder.substring(start, end);
                start = end;
                System.out.println(out);
            }
            builder.setLength(0);
        }
    }
}
