package lcof2;

public class p105 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = func(grid, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int func(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + func(grid, i + 1, j)
                + func(grid, i - 1, j)
                + func(grid, i, j + 1)
                + func(grid, i, j - 1);
    }
}
