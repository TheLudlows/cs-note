package lcof2;

import java.util.Stack;

public class p36 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack  = new Stack<>();

        for(int i=0;i<tokens.length;i++) {
            if(isNum(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                Integer i2 = Integer.parseInt(stack.pop());
                Integer i1 = Integer.parseInt(stack.pop());
                if(tokens[i].equals("+")) {
                    stack.push(String.valueOf(i1+i2));
                } else  if(tokens[i].equals("-")) {
                    stack.push(String.valueOf(i1-i2));
                } else  if(tokens[i].equals("*")) {
                    stack.push(String.valueOf(i1*i2));
                } else  if(tokens[i].equals("/")) {
                    stack.push(String.valueOf(i1/i2));
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private boolean isNum(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new p36().evalRPN(new String[]{"4","13","5","/","+"});
    }

}
