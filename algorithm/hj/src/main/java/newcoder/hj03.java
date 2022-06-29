package newcoder;

import java.util.*;

public class hj03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            Set<Integer> set = new HashSet<>();
            int n = scanner.nextInt();
            for(int i=0;i<n;i++) {
                set.add(scanner.nextInt());
            }
            int[] arr = new int[set.size()];
            List<Integer> arrList = new ArrayList(set);
            for(int i=0;i<arr.length;i++) {
                arr[i] = arrList.get(i);
            }
            Arrays.sort(arr);
            for(Integer i : arr) {
                System.out.println(i);
            }
        }
    }
}

