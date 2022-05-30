package lc;

import java.util.Stack;

public class p84_max {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int max = 0;
        for(int i=0;i<=heights.length;i++) {
            int cur ;
            if(i == heights.length) {
                cur = 0;
            } else {
                  cur =heights[i];
            }
            while (!stack.isEmpty() &&  cur < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int left;
                if(stack.isEmpty()) {
                    left = -1;
                } else {
                    left = stack.peek();
                }
                max = Math.max(max, (i-left-1) * h);
            }
            stack.push(i);
        }
        return max;
     }
}
