package nc;

import java.util.*;

public class hj27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().trim().split(" ");
        int k = Integer.parseInt(arr[arr.length - 1]);
        List<String> buddies = new ArrayList<>();
        String origin = arr[arr.length - 2];
        char[] ori_arr = origin.toCharArray();
        Arrays.sort(ori_arr);
        for (int i = 1; i < arr.length - 2; i++) {
            if (!origin.equals(arr[i])) {
                char[] cs = arr[i].toCharArray();
                Arrays.sort(cs);
                if (Arrays.equals(ori_arr, cs)) {
                    buddies.add(arr[i]);
                }
            }
        }
        Collections.sort(buddies);
        System.out.println(buddies.size());
        if (k <= buddies.size()) {
            System.out.println(buddies.get(k - 1));
        }
    }
}
