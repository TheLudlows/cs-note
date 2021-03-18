package lcof;

public class p13_movingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        return find(0, 0, m, n, k, vis);
    }

    private int find(int i, int j, int m, int n, int k, boolean[][] vis) {
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) {
            return 0;
        } else {
            vis[i][j] = true;
            int count = access(i, j, k) ? 1 +
                    find(i + 1, j, m, n, k, vis) +
                    find(i, j + 1, m, n, k, vis) +
                    find(i - 1, j, m, n, k, vis) +
                    find(i, j - 1, m, n, k, vis)
                    : 0;
            return count;
        }
    }

    boolean access(int i, int j, int k) {
        int res = 0;
        while (i > 0) {
            res += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            res += j % 10;
            j = j / 10;
        }
        return res <= k;
    }
}