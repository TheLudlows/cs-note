package local;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{9, 10, 4};
        arr[2] = new int[]{8, 7, 6};
        List<Integer> list = printArr(arr);

        for (Integer i : list) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static List<Integer> printArr(int[][] arr) {
        int top = 0;
        int bottom = arr.length - 1;
        int left = 0;
        int right = arr[0].length - 1;
        List<Integer> result = new ArrayList();
        while (top <= bottom && left <= right) {
            // 上层
            for (int i = left; i <= right; i++) {
                result.add(arr[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            // 右边
            for (int i = top; i <= bottom; i++) {
                result.add(arr[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            // 下层
            for (int i = right; i >= left; i--) {
                result.add((arr[bottom][i]));
            }
            bottom--;
            // 左边
            for (int i = bottom; i >= top; i--) {
                result.add((arr[i][left]));
            }
            left++;
        }
        return result;
    }
}
