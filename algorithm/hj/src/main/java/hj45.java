import java.util.Arrays;
import java.util.Scanner;

public class hj45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                String str = scanner.nextLine().toLowerCase();
                int[] count = new int[26];
                for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    count[c - 'a']++;
                }
                Arrays.sort(count);

                int total = 0;
                for(int j=0;j<26;j++) {
                    total += (j+1) * count[j];
                }
                System.out.println(total);
            }
        }
    }

}
