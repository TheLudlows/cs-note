package lcof2;

import java.util.*;

public class p61 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(Comparator.comparingInt(e -> nums1[e[0]] + nums2[e[1]]));
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<Math.min(k, nums1.length);i++) {
            queue.add(new Integer[]{i,0});
        }

        while(k > 0 && !queue.isEmpty()) {
            Integer[] arr = queue.poll();

            List<Integer> list = new ArrayList<>();
            list.add(nums1[arr[0]]);
            list.add(nums2[arr[1]]);
            result.add(list);
            arr[1] += 1;
            if(arr[1] < nums2.length) {
                queue.offer(arr);
            }
            k--;
        }
        return result;
    }
}
