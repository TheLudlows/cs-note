package lcof;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class p59_maxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int l = 0;
        int r = k - 1;
        int[] ret = new int[nums.length - k + 1];
        MaxQueue queue = new MaxQueue();
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        while (r < nums.length) {
            ret[l] = queue.peek();
            if (queue.peek() == nums[l]) {
                queue.pop();
            }
            l++;
            r++;
            if (r < nums.length)
                queue.push(nums[r]);
        }
        return ret;
    }


    static class MaxQueue {
        Deque<Integer> deque = new ArrayDeque<>();

        public void push(int n) {
            while (!deque.isEmpty() && deque.peekLast() < n) {
                deque.pollLast();
            }
            deque.offerLast(n);
        }

        public Integer pop() {
            return deque.pollFirst();
        }

        public Integer peek() {
            return deque.peekFirst();
        }

    }


    public static void main(String[] args) {
        int[] ret = maxSlidingWindow(new int[]{1, -3, 4, 2, 10, 11}, 3);
        System.out.println(Arrays.toString(ret));
    }
}
