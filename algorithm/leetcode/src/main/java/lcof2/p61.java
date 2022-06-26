package lcof2;

import java.util.*;

public class p61 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(Comparator.comparingInt(e -> nums1[e[0]] + nums2[e[1]]));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            queue.add(new Integer[]{i, 0});
        }

        while (k > 0 && !queue.isEmpty()) {
            Integer[] arr = queue.poll();

            List<Integer> list = new ArrayList<>();
            list.add(nums1[arr[0]]);
            list.add(nums2[arr[1]]);
            result.add(list);
            arr[1] += 1;
            if (arr[1] < nums2.length) {
                queue.offer(arr);
            }
            k--;
        }
        return result;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        // 构建大顶堆
        PriorityQueue<List<Integer>> queue = new PriorityQueue<List<Integer>>((e1,e2) -> {
           return Integer.compare(e2.get(0) + e2.get(1), e1.get(0) + e2.get(1));
        });

        int len1 = Math.min(nums1.length, k);
        int len2 = Math.min(nums2.length, k);
        for(int i=0;i<len1;i++) {
            for(int j=0;j<len2;j++) {
                List<Integer> top = queue.peek();
                if(queue.isEmpty() || nums1[i] + nums2[j] < top.get(0) + top.get(1)) {
                    queue.offer(Arrays.asList(nums1[i],nums2[j]));
                }
                if(queue.size() > k) {
                    queue.poll();
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}
