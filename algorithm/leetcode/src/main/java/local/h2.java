package local;

import java.util.Scanner;

public class h2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int start = 0;
            int max = 0;

            for (int i = 0; i < line.length(); i++) {
                int j = i;
                int dot = 0;
                if(line.charAt(j) == '4') {
                    System.out.println();
                }
                while (j < line.length() && (isNum(line.charAt(j)) || dot(line.charAt(j)))) {
                    if (dot(line.charAt(j))) {
                        if(j == i ) {
                            break;
                        }
                        dot++;
                        if (j == line.length() || j == 0 ||
                                !isNum(line.charAt(j - 1)) || !isNum(line.charAt(j + 1))) {
                            break;
                        }
                    }
                    if (dot > 1) {
                        break;
                    }
                    j++;
                }
                if (j - i > max) {
                    start = i;
                    max = j - i;
                }
            }

            if (max == 0) {
                System.out.println("");
            } else {
                System.out.println(line.substring(start, start + max));
            }
        }

    }

    public static boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean dot(char c) {
        return c == '.';
    }
}
