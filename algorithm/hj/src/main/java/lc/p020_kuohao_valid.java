package lc;

import java.util.Stack;

public class p020_kuohao_valid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if( c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if(c == '}') {
                    if(last != '{') {
                        return false;
                    }
                }
                if(c == ')') {
                    if(last != '(') {
                        return false;
                    }
                }
                if(c == ']') {
                    if(last != '[') {
                        return false;
                    }
                }

            }
        }
        return true && stack.size() == 0;
    }
}
