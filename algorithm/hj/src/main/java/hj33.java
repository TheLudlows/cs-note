import java.util.Scanner;

public class hj33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            String num = scanner.nextLine();
            ip2num(ip.trim());
            num2ip(num.trim());
        }
    }

    public static void ip2num(String ip) {
        String[] arr = ip.split("\\.");
        String out = new String();
        for (int i = 0; i < arr.length; i++) {
            int n = Integer.parseInt(arr[i]);
            String bin = Integer.toBinaryString(n);
            while (bin.length() < 8) {
                bin = "0" + bin;
            }
            out = out + bin;
        }
        System.out.println(Long.parseLong(out, 2));
    }

    public static void num2ip(String num) {
        String bin = Long.toBinaryString(Long.parseLong(num));
        String[] arr = new String[4];
        while (bin.length() % 8 != 0) {
            bin = "0" + bin;
        }
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(bin.substring(i * 8, i * 8 + 8), 2) + "";
        }
        System.out.println(String.join(".", arr));
    }
}
