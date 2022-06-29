package newcoder;

import java.util.*;

public class hj41 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] weightsArr = scanner.nextLine().split(" ");
            String[] countArr = scanner.nextLine().split(" ");

            int[] weights = new int[n];
            int[] count = new int[n];

            for (int i = 0; i < n; i++) {
                weights[i] = Integer.parseInt(weightsArr[i]);
                count[i] = Integer.parseInt(countArr[i]);
            }
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList(set);
                for (int j = 1; j < count[i]; j++) {
                    for (int k = 0; k < list.size(); k++) {
                        set.add(list.get(k) + weights[i] * j);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}
