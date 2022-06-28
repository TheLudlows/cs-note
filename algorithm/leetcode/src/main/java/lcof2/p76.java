package lcof2;


public class p76 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k ;
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int i, int j) {
        int p = partition(nums, i, j);
        if (p == k) {
            return nums[k];
        } else if (p > k) {
            return quickSelect(nums, k, i, p - 1);
        } else {
            return quickSelect(nums, k, p + 1, j);
        }
    }

    // 对撞指针，
    private static int partition(int[] nums, int i, int j) {
        int p = i;
        i+=1;
        while(i<=j) {
            if(nums[i] > nums[p]) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(nums, j, p);
        return j;
    }

    public static void main(String[] args) {
        int idx = partition(new int[]{3,5,4,1,2},0,4);
        System.out.println(idx);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
