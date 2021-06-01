package hj;

//todo
public class hj61 {
    public static void main(String[] args) {
        System.out.println(count(7, 3));
    }

    public static int count(int m, int n) {
        return dfs(m, n);
    }

    public static int dfs(int m, int n) {
        if (n == 0) {
            return 1;
        }
        if (m == 0) {
            return 1;
        }
        return dfs(m - 1, n) + dfs(m, n - 1);
    }
}
