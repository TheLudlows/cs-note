package lc;

import java.util.*;

public class MaxInter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String[] arr = scanner.nextLine().split(" ");
            List<Integer> integers = new ArrayList<>();
            integers.add(Integer.parseInt(arr[0]));
            integers.add(Integer.parseInt(arr[1]));
            list.add(integers);
        }
        Collections.sort(list, Comparator.comparing(e -> e.get(1)));

        Deque<List<Integer>> queue = new ArrayDeque<>();

        for(List<Integer> integerList : list) {
            if(queue.isEmpty()) {
                queue.offer(integerList);
            } else {
                List<Integer> last = queue.peekLast();
                if(last.get(1) <= integerList.get(0)) {
                    queue.offer(integerList);
                }
            }
        }

        System.out.println(queue.size());
    }
}
