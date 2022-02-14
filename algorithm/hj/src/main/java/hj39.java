import java.util.Scanner;

public class hj39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] mask = scanner.nextLine().split("\\.");
            String[] ip1 = scanner.nextLine().split("\\.");
            String[] ip2 = scanner.nextLine().split("\\.");

            int[] maskArr = parse(mask);
            if (!(checkMask(maskArr) && check(maskArr))) {
                System.out.println(1);
                continue;
            }
            int[] ip1Arr = parse(ip1);
            if (!check(ip1Arr)) {
                System.out.println(1);
                continue;
            }
            int[] ip2Arr = parse(ip2);
            if (!check(ip2Arr)) {
                System.out.println(1);
                continue;
            }

            if (isSubNet(maskArr, ip1Arr, ip2Arr)) {
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }
    }

    private static boolean isSubNet(int[] maskArr, int[] ip1Arr, int[] ip2Arr) {
        for (int i = 0; i < 4; i++) {
            if ((maskArr[i] & ip1Arr[i]) != (maskArr[i] & ip2Arr[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean check(int[] ipArr) {
        for (int i = 0; i < 4; i++) {
            if (ipArr[i] < 0 || ipArr[i] > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkMask(int[] maskArr) {
        String str = "";
        for (int i = 0; i < 4; i++) {
            str = str + getFullBin(maskArr[i]);
        }
        return str.lastIndexOf('1') + 1 == str.indexOf('0');
    }

    private static int[] parse(String[] mask) {
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(mask[i]);
        }
        return arr;
    }

    public static String getFullBin(int n) {
        String bin = Integer.toBinaryString(n);
        while (bin.length() < 8) {
            bin = bin + '0';
        }
        return bin;
    }
}
