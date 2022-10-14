package oj;

import java.util.Scanner;

public class kache {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        int len = Integer.parseInt(sc.nextLine());

        String[] arr = line.split(",");
        int[] nums = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        int count = 0;

        for(int i=0;i<nums.length-len;i++) {
            if(nums[i] == 1 && nums[i+len] == 1) {
                count ++;
                nums[i+len] = 0;
            }
        }
        System.out.println(count);
    }
}
