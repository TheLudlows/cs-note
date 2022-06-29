package newcoder;

import java.util.*;

public class hj77 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            List<List<Integer>> result = new ArrayList();
            Stack<Integer> stack = new Stack<Integer>();
            List<Integer> cur = new ArrayList<>();
            func(arr, 0, stack,cur, result);
            List<String> printStr= new ArrayList<>();

            for(List<Integer> list : result) {
                String s = "";
                for(Integer i : list) {
                    s = s + " " + i;
                }
                printStr.add(s);
            }

            Collections.sort(printStr);

            for(String str : printStr) {
                System.out.println(str);
            }
        }
    }

    private static void func(int[] arr, int idx, Stack<Integer> stack, List<Integer> path, List<List<Integer>> result) {
        if(path.size() == arr.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(idx < arr.length) {
            stack.push(arr[idx]);
            func(arr, idx + 1, stack, path, result);
            stack.pop();
        }

        if(!stack.isEmpty()) {
            int tmp = stack.pop();
            path.add(tmp);
            func(arr, idx, stack, path, result);
            stack.push(tmp);
            path.remove(path.size() - 1);
        }
    }
}

