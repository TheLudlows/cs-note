package lc;

import java.util.*;

public class p056_hebing {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> {
            return Integer.compare(e1[0], e2[0]);
        });

        Deque<int[]> queue = new ArrayDeque();

        for (int i = 0; i < intervals.length; i++) {
            if (!queue.isEmpty() && queue.peekLast()[1] >= intervals[i][0]) {
                int[] tmp = queue.peekLast();
                tmp[1] = Math.max(intervals[i][1], tmp[1]);
            } else {
                queue.offerLast(intervals[i]);
            }
        }
        int[][] res = new int[queue.size()][];
        for(int i=0;i<res.length;i++) {
            res[i] = queue.pollFirst();
        }
        return res;
    }
}


/**
 *  pub fn merge(intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
 *         let mut slice = intervals.clone();
 *         let mut merge: Vec<Vec<i32>> = Vec::new();
 *         slice.as_mut_slice().sort_by(|a, b| a[0].cmp(&b[0]));
 *         for v in slice {
 *             let l = v[0];
 *             let r = v[1];
 *             if merge.is_empty() || merge.last().unwrap()[1] < l {
 *                 merge.push(v);
 *             } else {
 *                 merge.last_mut().unwrap()[1] = std::cmp::max(merge.last().unwrap()[1], r);
 *             }
 *         }
 *         merge
 *     }
 */