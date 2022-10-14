package leetcode;

public class p1124_wpi {
    public static void main(String[] args) {

        Integer i1 = 10;
        Integer i2 = 10;

        Integer i3 = new Integer(10);
        Integer i4 = new Integer(10);


        Integer i5 = 1024;
        Integer i6 = 1024;

        System.out.println(i1==i2);
        System.out.println(i3==i4);


        long nl = 4664382371590123456L;

        double d2 =  nl * 2;
    }
}
class Solution {
    public int longestWPI(int[] hours) {
       int[] arr = new int[hours.length];
       for (int i=0;i<hours.length;i++) {
           if(hours[i] > 8) {
               arr[i] = 1;
           } else {
               arr[i] = -1;
           }
           if(i > 0) {
               arr[i] += arr[i-1];
           }
       }

        return 0;
    }


}