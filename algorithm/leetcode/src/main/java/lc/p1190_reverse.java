package lc;

import java.util.Stack;

public class p1190_reverse {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(builder.toString());
                builder.setLength(0);
            } else if (c == ')') {
                builder.reverse();
                builder.insert(0, stack.pop());
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String reverseParentheses2(String s) {
       return rev(s);
    }

    private String rev(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int j = i;
                int layer = 0;
                while (j < s.length()) {
                    if (s.charAt(j) == '(') {
                        layer++;
                    } else if (s.charAt(j) == ')') {
                        layer--;
                    }
                    if (layer == 0) {
                        break;
                    }
                    j++;
                }
                StringBuilder sub = new StringBuilder(rev(s.substring(i+1, j)));
                builder.append(sub.reverse());
                i = j;
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = new p1190_reverse().reverseParentheses2("(u(love)i)");

        System.out.println(s);
    }
}
