package hj;

import java.util.Scanner;

public class hj11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder0 = new StringBuilder();
        StringBuilder builder = new StringBuilder();

        String str = scanner.nextLine().trim();
        for(int i =0;i<str.length();i++ ) {
            char c =str.charAt(i);
            if(c == '0') {
                builder0.append(c);
            } else {
                builder.append(c);
            }
        }

        System.out.println(builder0.append(builder.reverse()).toString());
    }
 }
