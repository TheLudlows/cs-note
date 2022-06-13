package local;


import java.util.Scanner;

public class Main {

    static class Op {
        String cmd;
        int x;
        int y;

        Op(String s) {
            String[] line = s.split(" ");
            cmd = line[0];
            x = Integer.parseInt(line[1]);
            y = Integer.parseInt(line[2]);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int base = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[base][2];

        for (int i = 0; i < base; i++) {
            String[] line = scanner.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }

        int opCount = Integer.parseInt(scanner.nextLine());
        Op[] ops = new Op[opCount];
        for (int i = 0; i < opCount; i++) {
            ops[i] = new Op(scanner.nextLine());
        }
        int res = sum(rows, cols, arr, ops);
        System.out.println(res);
    }

    private static int sum(int rows, int cols, int[][] arr, Op[] ops) {
        int[][] matrix = new int[rows + 2][cols + 2];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int mrow = arr[i][0];
            int mcol = arr[i][1];
            matrix[mrow][mcol] = -1;
        }

        for (Op op : ops) {
            int x = op.x;
            int y = op.y;
            switch (op.cmd) {
                case "add":
                    if (matrix[x][y] == 0) {
                        matrix[x][y] = -1;
                    }
                    break;
                case "delete":
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            delete(x + i - 1, y + j - 1, matrix);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        int res = 0;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    int value = matrix[i - 1][j - 1] + matrix[i - 1][j + 1] + matrix[i - 1][j]
                            + matrix[i + 1][j - 1] + matrix[i + 1][j + 1] + matrix[i + 1][j]
                            + matrix[i][j - 1] + matrix[i][j + 1];
                    res += value;
                }
            }

        }
        return Math.abs(res);
    }

    private static void delete(int row, int col, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row != 0 && row != rows - 1 && col != 0 && col != cols - 1) {
            if (matrix[row][col] == -1) {
                matrix[row][col] = 0;
            }
        }
    }

}
