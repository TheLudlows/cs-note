package lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p547_shengfen {
    public int findCircleNum(int[][] isConnected) {
       boolean[] vit = new boolean[isConnected.length];
       int total = 0;
       for(int i=0;i<vit.length;i++) {
           if(!vit[i]) {
               dfs(vit, isConnected, i);
               total++;
           }
       }
       return total;
    }

    private void dfs(boolean[] vit, int[][] isConnected, int i) {
        for(int j=0;j<vit.length;j++) {
            if(!vit[j] && isConnected[i][j] == 1) {
                vit[j] = true;
                dfs(vit, isConnected, j);
            }
        }
    }
}
