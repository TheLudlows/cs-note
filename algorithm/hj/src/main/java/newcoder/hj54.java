package newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hj54 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(resolve(line, 0, line.length() - 1));
        }
    }

    private static int resolve(String line, int left, int right) {
        List<Integer> list = new ArrayList();

        int num = 0;
        int i = left;
        char op = '+';
        while (i <= right) {
            char c = line.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int j = i;
                int layer = 0;
                while (j <= right) {
                    c = line.charAt(j);
                    if (c == '(') {
                        layer += 1;
                    } else if (c == ')') {
                        layer -= 1;
                    }
                    if (layer == 0) {
                        break;
                    }
                    j++;
                }
                num = resolve(line, i+1, j-1);
                i = j;
            }

            if (i == right || !Character.isDigit(line.charAt(i))) {
                if (op == '+') {
                    list.add(num);
                } else if (op == '-') {
                    list.add(-num);
                } else if (op == '*') {
                    list.set(list.size() - 1, list.get(list.size() - 1) * num);
                } else if(op == '/'){
                    list.set(list.size() - 1, list.get(list.size() - 1) / num);
                }
                num = 0;
                op = c;
            }
            i++;
        }
        int res = 0;
        for (Integer v : list) {
            res += v;
        }
        System.out.println(res);
        return res;
    }
}
