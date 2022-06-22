package lc;

public class of13_fanwei {
    public int movingCount(int m, int n, int k) {
        boolean[][] vit = new boolean[m][n];
        return dfs(vit, 0, 0, k);
    }

    private int dfs(boolean[][] vit, int i, int j, int k) {
        if (i < 0 || i >= vit.length || j < 0 || j >= vit[0].length || vit[i][j] || countBit(i, j) > k) {
            return 0;
        }
        vit[i][j] = true;
        return 1 + dfs(vit, i + 1, j, k)
                + dfs(vit, i - 1, j, k)
                + dfs(vit, i, j + 1, k)
                + dfs(vit, i + 1, j - 1, k)
                ;
    }


    public int countBit(int i, int j) {
        int ret = 0;
        while (i > 0) {
            ret += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            ret += j % 10;
            j = j / 10;
        }
        return ret;
    }
}
