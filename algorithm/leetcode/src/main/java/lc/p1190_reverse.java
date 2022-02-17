package lc;

import java.util.ArrayList;
import java.util.List;
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
}
