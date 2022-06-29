package leetcode;

import java.util.ArrayList;
import java.util.List;

public class p54_xuanzhuan {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        int i,j;
        List<Integer> res = new ArrayList();
        while(top <= bottom && left <= right) {
            //
            i = top;j = left;
            for(;j<=right;j++) {
                res.add(matrix[i][j]);
            }
            top++;
            i = top;j= right;
            for(;i<=bottom;i++) {
                res.add(matrix[i][j]);
            }
            right--;
            if(bottom < top) {
                break;
            }
            i = bottom;j= right;
            for(;j>=left;j--) {
                res.add(matrix[i][j]);
            }
            bottom--;
            if(left > right) {
                break;
            }
            i = bottom;j = left;
            for(;i>=top;i--) {
                res.add(matrix[i][j]);
            }
            left++;
        }
        return res;
    }
}
