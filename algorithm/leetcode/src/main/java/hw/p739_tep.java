package hw;

import java.util.Stack;

public class p739_tep {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int k = stack.pop();
                res[k] = i-k;
            }
            stack.push(i);
        }
        return res;
    }
}
