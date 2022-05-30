package nc;

import java.util.*;
import java.util.stream.Collectors;

public class hj08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.trim();
        int n = Integer.parseInt(s);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<n;i++) {
            s = scanner.nextLine().trim();
            String[] arr = s.split(" ");
            int k = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);
            if (map.containsKey(k)) {
                int oldV = map.get(k);
                map.put(k, oldV + v);
            } else {
                map.put(k, v);
            }
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toList());
        for (Map.Entry<Integer,Integer> e : list) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
