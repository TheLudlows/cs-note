package lcof;

import java.util.Stack;

public class p31_validateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for(int j : pushed) {
          stack.push(j);
          while (!stack.isEmpty() && stack.peek() == popped[i]) {
              i++;
              stack.pop();
          }
        }
        return stack.isEmpty();
    }

}
