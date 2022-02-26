package h4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class h4 {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i=0;i<nums.length;i++) {
            total +=nums[i];
        }
        if(total % 2 != 0) {
            return false;
        }
        int[][] mem = new int[nums.length+1][total/2] ;
        for(int i=0;i<mem.length;i++) {
            mem[i] = new int[total/2+1];
            Arrays.fill(mem[i], -1);
        }
        return findPar(nums.length-1, nums, total/2, mem);

    }

    private boolean findPar(int i, int[] nums, int total, int[][] mem) {
        if( i < 0) {
            return total == 0;
        }
        if(total < 0) {
            return false;
        }
        if(mem[i][total] != -1) {
            return mem[i][total] == 1;
        }
        boolean res = findPar(i-1, nums, total-nums[i], mem) || findPar(i-1, nums, total, mem);

        if(res) {
            mem[i][total] = 1;
        } else {
            mem[i][total] = 0;
        }
        return res;

    }
}
