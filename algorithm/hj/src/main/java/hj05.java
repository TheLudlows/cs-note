import java.util.Scanner;

public class hj05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[256];
        arr['0'] = 0;
        arr['1'] = 1;
        arr['2'] = 2;
        arr['3'] = 3;
        arr['4'] = 4;
        arr['5'] = 5;
        arr['6'] = 6;
        arr['7'] = 7;
        arr['8'] = 8;
        arr['9'] = 9;
        arr['a'] = 10;
        arr['b'] = 11;
        arr['c'] = 12;
        arr['d'] = 13;
        arr['e'] = 14;
        arr['f'] = 15;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            line = line.toLowerCase();
            int res = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                res = res * 16 + arr[c];
            }
            System.out.println(res);
        }
    }
}
