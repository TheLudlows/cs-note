import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hj43 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = new int[m];
                line = scanner.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }
            List<List<Pos>> list = new ArrayList();
            List<Pos> cur = new ArrayList();

            new ArrayList(list);
            dfs(arr, 0, 0, list, cur);
            for (Pos p : list.get(0)) {
                System.out.println("(" + p.x + "," + p.y + ")");
            }
        }
    }

    private static void dfs(int[][] arr, int x, int y, List<List<Pos>> list, List<Pos> cur) {
        if (x == arr.length || y == arr[0].length) {
            return;
        }
        if (arr[x][y] == 1) {
            return;
        }
        int source = arr[x][y];
        arr[x][y] = 1;
        cur.add(new Pos(x, y));
        // top
        if (x - 1 >= 0 && arr[x - 1][y] == 0) {
            dfs(arr, x - 1, y, list, cur);
        }
        // bot
        if (x + 1 < arr.length && arr[x + 1][y] == 0) {
            dfs(arr, x + 1, y, list, cur);
        }
        // left
        if (y - 1 >= 0 && arr[x][y - 1] == 0) {
            dfs(arr, x, y - 1, list, cur);
        }

        // right
        if (y + 1 < arr[0].length && arr[x][y + 1] == 0) {
            dfs(arr, x, y + 1, list, cur);
        }
        if (x == arr.length - 1 && y == arr[0].length - 1) {
            list.add(new ArrayList<>(cur));
        }
        arr[x][y] = source;
        cur.remove(cur.size() - 1);
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
