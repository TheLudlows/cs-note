package local;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    static Set<Character> set = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flaw = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        int res = find(flaw, line);
        System.out.println(res);
    }

    private static int find(int flaw, String line) {
        int left = 0;
        int right = 0;
        int current = 0;
        int max = 0;
        int len = line.length();
        while (right < len) {
            if (!set.contains(line.charAt(right))) {
                current += 1;
            }
            while (current > flaw) {
                if (!set.contains(line.charAt(left))) {
                    current -= 1;
                }
                left += 1;
            }
            if (current == flaw && set.contains(line.charAt(left)) && set.contains(line.charAt(right))) {

                max = Math.max(max, right + 1 - left);
            }
            right += 1;

        }
        return max;
    }


}
