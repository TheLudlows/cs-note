package lcof;

import java.util.Arrays;

public class p29_spiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int top = 0;
        int bot = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        int[] ret = new int[matrix.length * matrix[0].length];
        int idx = 0;
        while (true) {
            for (int i = left; i <= right; i++) {
                ret[idx++] = matrix[top][i];
            }
            top++;
            if(top > bot) break;
            for (int i = top; i <= bot; i++) {
                ret[idx++] = matrix[i][right];
            }
            right--;
            if(right < left) break;
            for (int i = right; i >= left; i--) {
                ret[idx++] = matrix[bot][i];
            }
            bot--;
            if(bot < top) break;
            for (int i = bot; i >= top; i--) {
                ret[idx++] = matrix[i][left];
            }
            left++;
            if( left > right) break;

        }
        return ret;
    }
    public static void main(String[] args) {
      int[][] arr =   new int[][]{
              {1,2,3},{4,5,6}
      };
      int[]  res =  spiralOrder(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] spiralOrder2(int[][] matrix) {
        int hight = matrix.length;
        if (hight == 0) {
            return new int[]{};
        }
        int width = matrix[0].length;
        int left = 0, right = width - 1, top = 0, buttom = hight - 1;
        int[] arr = new int[hight*width];
        int index = 0;
        while (true) {
            //上边
            for (int i = left; i <= right; ++i) {
                arr[index++] = matrix[top][i];
            }
            top++;
            //右边，这里注意是大于，不可以等于，因为我们实际时是索引
            //下面同理
            if (top > buttom) break;
            for (int i = top; i <= buttom; ++i) {

                arr[index++] = matrix[i][right];

            }
            right--;
            if (right < left) break;

            //下边
            for (int i = right; i >= left; --i) {
                arr[index++] = matrix[buttom][i];
            }
            buttom--;
            if (buttom < top) break;

            //左边
            for (int i = buttom; i >= top; --i) {
                arr[index++] = matrix[i][left];
            }
            left++;
            if (left > right) break;

        }
        return arr;
    }
}
