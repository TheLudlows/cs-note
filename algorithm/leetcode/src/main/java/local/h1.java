package local;

import java.util.Scanner;

public class h1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String line = scanner.nextLine();


            String[] strs = line.split(" ");

            if(strs.length <= 1) {
                System.out.println(-1);
                continue;
            }

            boolean flag = false;

            int[] arr = new int[strs.length - 1];
            for (int i = 0; i < arr.length; i++) {
                try {
                    arr[i] = Integer.parseInt(strs[i]);
                    if(arr[i] < 0) {
                        flag = true;
                    }
                }catch (Exception e) {
                    flag = true;
                    break;
                }
            }
            try {
                int h = Integer.parseInt(strs[strs.length - 1]);
                if(h <= 0) {
                    System.out.println(-1);
                    continue;
                }
            }catch (Exception e) {
                System.out.println(-1);
                continue;
            }
            if(flag) {
                System.out.println(-1);
            } else {
                int maxSpeed = Integer.MIN_VALUE;
                int h = Integer.parseInt(strs[strs.length - 1]);

                for(int i: arr) {
                    maxSpeed = Math.max(maxSpeed, i);
                }

                int left = 1;
                int right = maxSpeed;

                while(left < right) {
                    int mid = left+(right-left)/2;
                    if(eatHour(mid, arr) > h) {
                        left = mid+1;
                    }else {
                        right=mid;
                    }
                }
                System.out.println(left);
            }
        }
    }

    public static int eatHour(int speed, int[] arr) {
        int h = 0;
        for(int i : arr) {
            h += (i+speed-1)/speed;
        }
        return h;
    }
}
