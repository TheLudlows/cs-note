import java.util.Scanner;
import java.util.Stack;

public class hj70 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLine();
            }
            String str = scanner.nextLine();
            Stack<Integer> stack = new Stack();
            int idx = 0;
            int total = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(') {
                    continue;
                } else if (c == ')') {
                    // 出栈 计算
                    int ty2 = stack.pop();
                    int tx2 = stack.pop();
                    int ty1 = stack.pop();
                    int tx1 = stack.pop();
                    total += tx1 * ty1 * ty2;
                    stack.push(tx1);
                    stack.push(ty2);
                } else {
                    String[] intStr = arr[idx].split(" ");
                    stack.push(Integer.parseInt(intStr[0]));
                    stack.push(Integer.parseInt(intStr[1]));
                    idx++;
                }
            }
            System.out.println(total);

        }
    }
}
