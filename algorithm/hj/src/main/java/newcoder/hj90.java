package newcoder;

import java.util.Scanner;

public class hj90 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] arr = scanner.nextLine().split("\\.");
            boolean flag = true;
            if(arr.length != 4) {
                System.out.println("NO");
                continue;
            }
            for(int i=0;i<arr.length;i++) {
                try {
                    int n = Integer.parseInt(arr[i]);
                    if(arr[i].startsWith("0") && !arr[i].equals(n + "")) {
                        flag = false;
                        break;
                    }
                    if(arr[i].startsWith("+")) {
                        flag = false;
                        break;
                    }
                    if (n < 0 || n > 255) {
                        flag = false;
                        break;
                    }
                }catch(Exception e) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
