package lcof;

class Solution {
    // 最小值 ，右边
    public int minArray(int[] arr) {
        int l = 0;
        int r = arr.length-1;

        while (l < r) {
            int mid = l + r >> 1;
            if(arr[mid] > arr[r]) {
                l = mid + 1;
            } else if (arr[mid] < arr[r]){
                r = mid ;
            } else {
                r -=1;
            }
        }
        return arr[l];
    }
}