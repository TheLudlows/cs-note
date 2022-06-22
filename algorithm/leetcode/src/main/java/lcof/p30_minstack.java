package lcof;

import java.util.Stack;

public class p30_minstack {

    Stack<Integer> descStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();


    /** initialize your data structure here. */
    public void MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        if(descStack.isEmpty() || descStack.peek() > x) {
            descStack.push(x);
        }
    }

    public void pop() {
       int x = stack.pop();
        if(descStack.size() > 0  && x == descStack.peek()) {
            descStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
       return descStack.peek();
    }
}