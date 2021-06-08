package lc;

public class squareUniqueNum {

    public static void main(String[] args) {
        int[] arr = new int[]{-5,-3,-1,1,1,2};
        int n = squareUniqueNum(arr);
        System.out.println(n);
    }

    public static int squareUniqueNum(int[] arr) {
        int count = 1;
        int i = 0;
        int j = arr.length - 1;
        int pre = Math.abs(arr[0]);
        while (i <= j) {
            int x = Math.abs(arr[i]);
            int y = Math.abs(arr[j]);
            if (x > y) {
                if (x != pre) {
                    count++;
                    pre = x;
                }
                i++;
            } else {
                if (x != pre) {
                    count++;
                    pre = x;
                }
                j--;
            }
        }
        return count;
    }
}
