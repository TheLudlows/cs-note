package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class p0739_wendu {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<temperatures.length;i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
               int idx = stack.pop();
               res[idx] = i - idx ;
            }
            stack.push(i);
        }
        return res;
    }
}
