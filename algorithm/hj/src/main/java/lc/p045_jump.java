package lc;

public class p045_jump {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int jump = 0;
        while (r < nums.length - 1) {
            int maxPos = 0;
            for (int i = l; i <= r; i++) {
                maxPos = Math.max(maxPos, i+nums[i]);
            }
            l = r + 1;

            r = maxPos;
            jump++;
        }
        return jump;
    }

    public static void main(String[] args) {
        new p045_jump().jump(new int[]{2,3,1,1,4});
    }
}
