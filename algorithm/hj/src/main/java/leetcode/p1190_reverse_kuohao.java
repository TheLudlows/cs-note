package leetcode;

/**
 * 递归
 */
public class p1190_reverse_kuohao {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();) {
            char c = s.charAt(i);
            if(c == '(') {
                int count = 0;
                int j = i;
                for(;j<s.length();j++) {
                    if(s.charAt(j) == '(') {
                        count++;
                    }
                    if(s.charAt(j) == ')') {
                        count--;
                    }
                    if(count == 0) {
                        break;
                    }
                }
                // 外层的括号再本次递归中逆序，去括号后交给下一个递归
                StringBuilder sb2 = new StringBuilder(reverseParentheses(s.substring(i+1,j)));
                sb.append(sb2.reverse());
                i = j+1;
            } else {
                sb.append(c);
                i++;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new p1190_reverse_kuohao().reverseParentheses("(abc)"));
    }
}
