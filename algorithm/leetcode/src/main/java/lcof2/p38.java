package lcof2;

import java.util.Stack;

public class p38 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++) {
            int cur = temperatures[i];
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }
}
