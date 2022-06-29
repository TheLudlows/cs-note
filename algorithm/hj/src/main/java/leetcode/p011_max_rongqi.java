package leetcode;

public class p011_max_rongqi {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;

        while (right> left) {
            int area = (right - left) * Math.min(height[right],height[left]);
            max = Math.max(area, max);
            if(height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
