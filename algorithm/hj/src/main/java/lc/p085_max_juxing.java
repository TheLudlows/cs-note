package lc;

import java.util.Stack;

public class p085_max_juxing {
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                    arr[j]+=1;
                }
            }
            max = Math.max(maxRec(arr), max);
        }
        return max;
    }

    private int maxRec(int[] arr) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<=arr.length;i++) {
            int cur;
            if(i == arr.length) {
                cur = 0;
            }else {
                cur = arr[i];
            }
            while (!stack.isEmpty() && cur < arr[stack.peek()]) {
                int h = arr[stack.pop()];
                int right = i;
                int left = -1;
                if(!stack.isEmpty()) {
                    left = stack.peek();
                }
                max = Math.max(max, (right-left - 1) * h);
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'1','0'}};
        new p085_max_juxing().maximalRectangle(arr);
    }
}
