package h2;

import java.util.*;

public class h2 {
    public int minMeetingRooms(int[][] intervals) {
        Deque<int[]> queue = new ArrayDeque<>();

        Arrays.sort(intervals, (e1, e2) -> Integer.compare(e2[0], e1[0]));

        for(int i=0;i<intervals.length;i++) {
            if(queue.isEmpty()) {
                queue.offer(intervals[i]);
            } else {
                int[] last = queue.peekLast();
                if(last[1] <= intervals[i][1]) {
                    last[1] =  intervals[i][1];
                } else {
                    queue.offer(intervals[i]);
                }
            }
        }
        return queue.size();
    }
}
