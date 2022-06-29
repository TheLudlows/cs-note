package newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hj02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String key = scanner.nextLine();
        String[] arr = line.split("");

        Map<String, Integer> map = new HashMap<>();

        for(String s : arr) {
            s = s.toLowerCase();
            Integer count = map.getOrDefault(s, 0);
            count+=1;
            map.put(s, count);
        }
        System.out.println(map.getOrDefault(key.toLowerCase(), 0));
    }
}
