package lcof2;

public class p116 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vit = new boolean[isConnected.length];
        int res = 0;
        for(int i=0;i<isConnected.length;i++) {
            if(!vit[i]) {
                func(vit, isConnected, i);
                res++;
            }
        }
        return res;
    }

    private void func(boolean[] vit, int[][] isConnected, int i) {
        if(vit[i]) {
            return;
        }
        vit[i] = true;
        for(int j= 0; j<isConnected[i].length;j++) {
            if(isConnected[i][j] == 1) {
                func(vit, isConnected, j);
            }
        }
    }
}
