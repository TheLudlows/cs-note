package nc;

import java.util.Arrays;
import java.util.Scanner;

public class hj59 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
           String line = scanner.nextLine();
           char[] arr = line.toCharArray();
           int[] map = new int[256];

           for(int i=0;i<arr.length;i++) {
               map[arr[i]] +=1;
           }
           boolean flag = false;
           for(int i=0;i<arr.length;i++) {
               if(map[arr[i]] == 1) {
                   System.out.println(arr[i]);
                   flag = true;
                   break;
               }
           }
           if(!flag) {
               System.out.println(-1);
           }
        }
    }
}
