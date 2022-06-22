package lcof2;

import java.util.PriorityQueue;

public class p59 {
    class KthLargest {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                if (queue.size() < k) {
                    queue.offer(nums[i]);
                } else {
                    int min = queue.peek();
                    if (min < nums[i]) {
                        queue.poll();
                        queue.offer(nums[i]);
                    }
                }
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.offer(val);
            } else {
                int min = queue.peek();
                if (min < val) {
                    queue.poll();
                    queue.offer(val);
                }
            }
            return queue.peek();
        }

    }
}
