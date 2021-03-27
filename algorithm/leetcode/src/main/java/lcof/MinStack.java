package lcof;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> min;

    @Override
    public String toString() {
        return "MinStack{" +
                "data=" + data +
                ", min=" + min +
                '}';
    }

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(!min.isEmpty() && min.peek() < x) {
            return;
        }
        min.push(x);
    }

    public void pop() {
        Integer n = data.pop();
        if(n != null && n.equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

    // ["","push","push","push","push","pop","min","pop","min","pop","min"]
    //[,[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack);

        System.out.println(minStack.min());
    }
}
