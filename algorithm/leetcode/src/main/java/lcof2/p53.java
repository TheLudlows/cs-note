package lcof2;

public class p53 {

    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
         int left = searchLeft(nums,target);
        int right = searchRight(nums, target);
        if(left == -1) {
            return 0;
        }
        return right - left + 1;
    }


    public int searchNormal(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }




    public static int searchLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else if (target == nums[mid]) {
                r = mid - 1;
            }
        }
        if(l >= nums.length) {
            return -1;
        }
        return nums[l] == target ? l : -1;
    }

    public static int searchRight(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r + 1) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else if (target == nums[mid]) {
                l = mid + 1;
            }
        }
        if(r < 0) {
            return -1;
        }
        return nums[r] == target ? r : -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2};
        int res = searchLeft(arr, 2);
        System.out.println(res);

        res = searchRight(arr, 2);
        System.out.println(res);
    }
}
