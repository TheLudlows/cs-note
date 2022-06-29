package leetcode;

import java.util.ArrayList;
import java.util.List;

public class p046_pailie {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> cur = new ArrayList();
        int[] vit = new int[nums.length];

        func(res, cur, vit, nums);
        return res;
    }

    private void func(List<List<Integer>> res, List<Integer> cur, int[] vit, int[] nums) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(vit[i] == 1) {
                continue;
            }
            vit[i] = 1;
            cur.add(nums[i]);
            func(res, cur, vit, nums);
            vit[i] = 0;
            cur.remove(cur.size() - 1);
        }

    }
}
