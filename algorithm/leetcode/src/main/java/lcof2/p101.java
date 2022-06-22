package lcof2;

public class p101 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(Integer i : nums ){
            sum+=i;
        }
        if(sum % 2 != 0) {
            return false;
        }

        sum /=2;
        int[][] dp = new int[nums.length][sum];
        return false;
    }
}
