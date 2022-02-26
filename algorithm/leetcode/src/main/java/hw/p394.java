package hw;

public class p394 {

    public String decodeString(String s) {
        return solve(s);
    }

    private String solve(String s) {
        int num = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                int j = i;
                int layer = 0;
                while (j < s.length()) {
                    if (s.charAt(j) == '[') {
                        layer++;
                    } else if (s.charAt(j) == ']') {
                        layer--;
                    }
                    if (layer == 0) {
                        break;
                    }
                    j++;
                }
                String sub = solve(s.substring(i + 1, j));
                cur.append(sub);
                for (int k = 0; k < num; k++) {
                    res.append(cur);
                }
                cur.setLength(0);
                num = 0;
                i = j;
                // 递归处理
            } else {
                // append
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new p394().decodeString("3[a2[bc]]"));
    }
}
