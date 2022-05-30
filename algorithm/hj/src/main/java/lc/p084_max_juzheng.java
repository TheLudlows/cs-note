package lc;

import java.util.Stack;

/**
 * 最大面积，确定长/宽 去讨论另一个，暴力法
 * 单调栈确定左右边界，左右边界是第一个的元素，右边再遍历过程中可以确定，左边界是栈的下一个元素，
 * 如果栈没有元素说明 前面所有的元素都已经出栈 left = -1
 */
public class p084_max_juzheng {

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
                int h = heights[stack.pop()];
                int left;
                int right = i;
                if(!stack.isEmpty()) {
                    left = stack.peek();
                } else {
                    left = -1;
                }
                max = Math.max(max, h * (right - left - 1));
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        new p084_max_juzheng().largestRectangleArea(new int[]{2,0,2});
    }
}
