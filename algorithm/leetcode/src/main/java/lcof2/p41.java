package lcof2;

import java.util.ArrayDeque;
import java.util.Deque;

public class p41 {
    class MovingAverage {
        Deque<Integer> queue = new ArrayDeque();
        int windows;
        int total = 0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            windows = size;
        }

        public double next(int val) {
            total += val;
            queue.offerLast(val);
            if(queue.size() > windows) {
                total -= queue.pollFirst();
            }
            return total*1.0 / queue.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
