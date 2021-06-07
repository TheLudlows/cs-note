package iv;

import java.util.Scanner;

public class MaxProfile {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] arr = s.split(" ");

        int[] prices = new int[arr.length];

        for(int i=0;i<prices.length;i++) {
            if(arr[i].endsWith("S")) {
                prices[i] = Integer.valueOf(arr[i].substring(0,1))*7;
            } else {
                prices[i] = Integer.valueOf(arr[i].substring(0,1));
            }
        }
        int ret = Math.max(Math.max
                (find(prices, prices.length-1, 0), find(prices, prices.length-1, 1)), find(prices, prices.length-1, 2));
        System.out.println(ret);
    }

    private static int find(int[] prices, int i, int flag) {
        if(i < 0) {
            return 0;
        }

        int ret = 0;
        int buy = 0;
        int sell = 0;

        if(flag == 0) {
             buy = -prices[i] + find(prices, i-1, 1);
        } else if (flag == 1) {
             sell = prices[i] + find(prices, i-1, 0);
        } else {
            ret = Math.max(Math.max(find(prices, i-1, 1), find(prices, i-1, 0)),find(prices, i-1, 2));
        }
        ret = Math.max(ret, Math.max(buy, sell));
        return ret;
    }

}
