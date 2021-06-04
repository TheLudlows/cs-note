package lc;

import java.util.*;

// 单调栈，下一个更大的元素
public class NextLarge {

    public static void main(String[] args) {
        int[] ret = nextLarge(new int[] {5,4,3,2,9});
        System.out.println(Arrays.toString(ret));
    }

    public static int[] nextLarge(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[arr.length];
        for(int i=0;i<arr.length; i++) {
            while(!stack.empty() && arr[i] > arr[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i;
            }
            stack.push(i);
        }
        while(!stack.empty()) {
            int idx = stack.pop();
            ret[idx] = -1;
        }
        return ret;
    }

}
