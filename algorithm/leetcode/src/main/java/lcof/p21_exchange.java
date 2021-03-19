package lcof;

public class p21_exchange {
    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (r > l) {
            if(nums[l] % 2 == 1) {
                l++;
            } else if(nums[r] % 2 == 0) {
                r--;
            } else  {
                swap(nums,r,l);
            }
        }
        return nums;
    }

    public static final void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
