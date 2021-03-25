package lcof;

import java.util.ArrayList;
import java.util.List;

// 双指针 滑动窗口
public class pfindContinuousSequence {

    public static int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 2;
        int sum = 3;
        List<int[]> list = new ArrayList<>();
        while (l < r) {
            if (sum == target) {
                int[] arr = new int[r - l + 1];
                for (int i = l, j = 0; i <= r; i++, j++) {
                    arr[j] = i;
                }
                list.add(arr);
                l++;
                sum -= l;
            } else if (sum > target) {
                sum -= l;
                l++;
            } else {
                r++;
                sum += r;
            }
        }

        int[][] ret = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }

}
