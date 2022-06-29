package local;

public class Main4 {

    public static void main(String[] args) {
        int[][] arr = new int[4][];
        arr[0] = new int[]{0,1,1,0};
        arr[1] = new int[]{0,1,1,0};
        arr[2] = new int[]{0,0,1,0};
        arr[3] = new int[]{0,0,1,0};
        System.out.println(maxAren(arr));
    }


    public static int maxAren(int[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    max = Math.max(max, find(arr, i, j));
                }
            }
        }
        return max;
    }

    private static int find(int[][] arr, int i, int j) {
        if (i < 0 || i == arr.length || j < 0 || j == arr[0].length || arr[i][j] == 0) {
            return 0;
        }
        arr[i][j] = 0;
        return 1 + find(arr, i + 1, j)
                + find(arr, i - 1, j)
                + find(arr, i, j + 1)
                + find(arr, i, j - 1);
    }

}
