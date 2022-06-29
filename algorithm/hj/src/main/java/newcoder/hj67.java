package newcoder;

import java.util.Scanner;
import java.util.Stack;

public class hj67 {
    static Stack<Integer> stack = new Stack<Integer>();
    static Stack<String> stack2 = new Stack();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] vis = new int[4];
            boolean flag  = false;
            for (int i = 0; i < 4; i++) {
                vis[i] = 1;
                stack.push(arr[i]);
                if (find(arr, 1, arr[i], vis)) {
                    System.out.println("true");
                    flag = true;
                    break;
                }
                stack.pop();

                vis[i] = 0;
            }
            if(!flag)
            System.out.println("false");

        }

    }

    public static boolean find(int[] arr, int num, double total, int[] vis) {
        if (num == 4) {
            if(total == 24) {
                System.out.println(stack.toString());
                System.out.println(stack2.toString());
            }
            return total == 24;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (vis[i] == 0) {
                    stack.push(arr[i]);
                    vis[i] = 1;
                    stack2.push("+");
                    boolean res = find(arr, num + 1, total + arr[i], vis);
                    stack2.pop();
                    if(res) {
                        return true;
                    }
                    stack2.push("-");
                    res =   find(arr, num + 1, total - arr[i], vis) ;
                    stack2.pop();
                    if(res) {
                        return true;
                    }
                    stack2.push("*");

                    res = find(arr, num + 1, total * arr[i], vis);
                    stack2.pop();
                    if(res) {
                        return true;
                    }
                    stack2.push("/");
                    res = find(arr, num + 1, total / arr[i], vis);
                    stack2.pop();

                    if (res) {
                        return true;
                    }
                    stack.pop();
                    vis[i] = 0;
                }
            }
            return false;
        }
    }
}
