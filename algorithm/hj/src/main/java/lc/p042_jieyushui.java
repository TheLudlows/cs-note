package lc;

import java.util.Stack;

public class p042_jieyushui {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0;i<height.length;i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int right = i;
                max = Math.max(max, (right-left-1) * (Math.max(height[left],height[right]) - height[mid]));
            }
            stack.push(i);
        }
        return max;
    }
}
