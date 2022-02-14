import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hj23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            Map<Character, Integer> map = new HashMap<>();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                int n = map.getOrDefault(c, 0);
                n += 1;
                map.put(c, n);
            }
            for (int i : map.values()) {
                min = Math.min(i, min);
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (map.get(c) != min) {
                    builder.append(c);
                }
            }
            System.out.println(builder);
        }
    }
}
