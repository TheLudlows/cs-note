package nc;

import java.util.Scanner;

public class hj96 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (isNum(c)) {
                    if (i == 0 || (i > 0 && !isNum(line.charAt(i - 1)))) {
                        sb.append("*");
                    }
                    sb.append(c);
                    if (i == line.length() - 1 || (i < line.length() - 1 && !isNum(line.charAt(i + 1)))) {
                        sb.append('*');
                    }
                } else {
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
