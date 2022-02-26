package hw;

import java.util.Stack;

public class p42 {
    public int trap(int[] height) {

        int total = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0;i<height.length;i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = height[stack.pop()];
                if(stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int right = i;

                total+= (Math.min(height[left],height[right]) - cur) * (right - left -1);
            }
            stack.push(i);
        }
        return total;
    }
}
