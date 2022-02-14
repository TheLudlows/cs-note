package lc;

import java.util.Stack;

public class p0042 {

    public int trap(int[] height) {
        int total = 0;

        for(int i =0;i<height.length;i++) {
            int left = findLeft(height, i);
            int right = findRight(height, i);
            if(right >= height.length || left < 0) {
                continue;
            } else {
                total += (Math.min(height[left], height[right]) - height[i]);
            }
        }
        return total;
    }

    public int trap2(int[] height) {
        int total = 0;
        Stack<Integer> stack = new Stack();
        for(int i =0;i<height.length;i++) {
           while(!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int cur = height[stack.pop()];
                if(stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                total += (i - left - 1) * (Math.min(height[i], height[left]) - cur);
           }
           stack.push(i);
        }
        return total;
    }

    public int findLeft(int[] arr, int idx) {
        int maxIdx = idx;
        while(idx >= 0) {
            if(arr[idx] > arr[maxIdx]) {
                maxIdx = idx;
            }
            idx--;
        }
        return maxIdx;
    }

    public int findRight(int[] arr, int idx) {
        int maxIdx = idx;
        while(idx < arr.length) {
            if(arr[idx] > arr[maxIdx]) {
                maxIdx = idx;
            }
            idx++;
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,0,0,4};
        System.out.println(new p0042().trap2(arr));
    }
}
