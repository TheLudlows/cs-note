package newcoder;

import java.util.Arrays;
import java.util.Scanner;

public class hj52 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            int[][] mem = new int[s1.length()][s2.length()];
            for (int i = 0; i < s1.length(); i++) {
                mem[i] = new int[s2.length()];
                Arrays.fill(mem[i], -1) ;
            }
            int min = distcane(s1, s2, s1.length() - 1, s2.length() - 1, mem);

            System.out.println(min);
        }
    }

    private static int distcane(String s1, String s2, int i, int j, int[][] mem) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if(mem[i][j] != -1) {
            return mem[i][j];
        }
        int dis;
        if (s1.charAt(i) == s2.charAt(j)) {
            dis = distcane(s1, s2, i - 1, j - 1, mem);
        } else {
            dis = 1 + Math.min(distcane(s1, s2, i - 1, j - 1, mem), Math.min(distcane(s1, s2, i - 1, j, mem), distcane(s1, s2, i, j - 1, mem)));
        }
        mem[i][j] = dis;
        return dis;
    }
}
