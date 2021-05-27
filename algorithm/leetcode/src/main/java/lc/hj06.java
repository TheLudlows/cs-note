package lc;

import java.io.IOException;

public class hj06 {

    public static void main(String[] args) throws IOException {

        int num = 5;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                sb.append(i).append(" ");
                num = num / i;
            }
        }
        System.out.println(sb.toString());
    }

}