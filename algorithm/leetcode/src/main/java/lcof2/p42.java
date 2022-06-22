package lcof2;

import java.util.ArrayDeque;
import java.util.Deque;

public class p42 {
    class RecentCounter {
        int count = 0;
        Deque<Integer> deque;
        public RecentCounter() {
            deque = new ArrayDeque<Integer>();
        }

        public int ping(int t) {
            count++;
            deque.offerLast(t);
            while(deque.peekFirst() < t -3000) {
                deque.pollFirst();
                count--;
            }
            return count;

        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
