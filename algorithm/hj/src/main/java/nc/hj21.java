package nc;

import java.util.Scanner;

public class hj21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (c != 'Z') {
                    c = (char) (c + 32 + 1);
                } else {
                    c = 'a';
                }
            } else if (c >= 'a' && c <= 'z') {
                if (c >= 'a' && c <= 'c') {
                    c = '2';
                } else if (c >= 'd' && c <= 'f') {
                    c = '3';
                } else if (c >= 'g' && c <= 'i') {
                    c = '4';
                } else if (c >= 'j' && c <= 'l') {
                    c = '5';
                } else if (c >= 'm' && c <= 'o') {
                    c = '6';
                } else if (c >= 'p' && c <= 's') {
                    c = '7';
                } else if (c >= 't' && c <= 'v') {
                    c = '8';
                } else if (c >= 'w' && c <= 'z') {
                    c = '9';
                }
            }
            builder.append(c);
        }
        System.out.println(builder);
    }

}
