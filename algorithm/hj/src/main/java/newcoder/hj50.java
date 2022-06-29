package newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hj50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            line = line.replaceAll("\\{", "(");
            line = line.replaceAll("\\}", ")");
            line = line.replaceAll("\\[", "(");
            line = line.replaceAll("\\]", ")");
            int res = resolve(line, 0, line.length() - 1);
            System.out.println(res);
        }
    }

    private static int resolve(String line, int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        char op = '+';
        int num = 0;
        for (int i = left; i <= right; i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int j = i;
                int layer = 0;
                while (j <= right) {
                    if (line.charAt(j) == '(') {
                        layer++;
                    } else if (line.charAt(j) == ')') {
                        layer--;
                    }

                    if (layer == 0) {
                        break;
                    }
                    j++;
                }
                num = resolve(line, i + 1, j - 1);
                i = j;
            }

            if (i == right || !Character.isDigit(line.charAt(i))) {
                if (op == '+') {
                    res.add(num);
                } else if (op == '-') {
                    res.add(-num);
                } else if (op == '*') {
                    res.set(res.size() - 1, res.get(res.size() - 1) * num);
                } else if (op == '/') {
                    res.set(res.size() - 1, res.get(res.size() - 1) / num);
                }
                op = line.charAt(i);
                num = 0;
            }
        }
        int ret = 0;

        for (int n : res) {
            ret += n;
        }
        //System.out.println(ret);
        return ret;
    }
}
