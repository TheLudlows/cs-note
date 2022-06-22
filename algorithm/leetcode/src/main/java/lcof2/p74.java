package lcof2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class p74 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        Deque<int[]> deque = new ArrayDeque();
        for(int i=0;i<intervals.length;i++) {
            if(!deque.isEmpty()) {
                int[] old = deque.peekLast();
                if(old[1] >= intervals[i][0]) {
                    old[1] = Math.max(intervals[i][1], old[1]);
                } else {
                    deque.offerLast(intervals[i]);
                }
            } else {
                deque.offerLast(intervals[i]);
            }
        }
        int[][] res = new int[deque.size()][];
        for(int i=0;i<res.length;i++) {
            res[i] = deque.pollFirst();
            System.out.println(Arrays.toString(res[i]));
        }
        return res;
    }
}
