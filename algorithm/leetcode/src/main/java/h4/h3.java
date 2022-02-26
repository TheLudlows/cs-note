package h4;

import java.util.HashSet;
import java.util.Set;

public class h3 {
    // 区分两种o
    public void solve(char[][] board) {
        for(int i=0;i<board[0].length;i++) {
            if(board[0][i] == 'O') {
                dfs(0,i, board);
            }
            if(board[board.length-1][i] == 'O') {
                dfs(board.length-1,i, board);
            }
        }

        for(int i=0;i<board.length;i++) {
            if(board[i][0] == 'O') {
                dfs(i,0, board);
            }
            if(board[i][board[0].length-1] == 'O') {
                dfs(i,board[0].length-1, board);
            }
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j,char[][] board) {
        if(i< 0 || i >= board.length || j < 0 || j >= board[0].length ||
            board[i][j] != 'O'
        ) {
            return;
        }
        board[i][j] = '#';
        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j-1, board);
        dfs(i, j+1, board);
    }
}
