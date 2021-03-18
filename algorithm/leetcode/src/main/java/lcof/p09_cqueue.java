package lcof;

import java.util.Stack;

public class p09_cqueue {
    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.size() == 0) {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.size() == 0) {
                return -1;
            }
            return stack2.pop();
        }
    }
}
