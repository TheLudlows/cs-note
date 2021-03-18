package lcof;

import java.util.Arrays;

public class p12_exist {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, chars, 0, i, j, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, char[] chars, int idx, int i, int j, boolean[][] vis) {
        if (i < 0 || i >= vis.length || j < 0 || j >= vis[0].length || vis[i][j] || chars[idx] == board[i][j]) {
            return false;
        }
        if (idx == chars.length - 1) {
            return true;
        }
        vis[i][j] = true;
        boolean res =
                find(board, chars, idx + 1, i + 1, j, vis)
                || find(board, chars, idx + 1, i, j + 1, vis)
                || find(board, chars, idx + 1, i - 1, j, vis)
                || find(board, chars, idx + 1, i, j - 1, vis);
        vis[i][j] = false;
        return res;
    }

}
