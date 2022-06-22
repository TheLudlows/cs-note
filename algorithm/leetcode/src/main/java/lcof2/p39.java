package lcof2;

import java.util.Stack;

public class p39 {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur;
            if (i == heights.length) {
                cur = 0;
            } else {
                cur = heights[i];
            }
            while (!stack.isEmpty() && cur < heights[stack.peek()]) {
                int right = i;
                int left = -1;
                int height = heights[stack.pop()];
                if (!stack.isEmpty()) {
                    left = stack.peek();
                }
                max = Math.max(max, ((right - left - 1) * height));
            }
            stack.push(i);
        }
        return max;
    }
}
