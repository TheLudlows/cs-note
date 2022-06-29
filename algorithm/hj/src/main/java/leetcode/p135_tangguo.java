package leetcode;

import java.util.Arrays;

public class p135_tangguo {
    public int candy(int[] ratings) {
       int[] candy = new int[ratings.length];
       Arrays.fill(candy,1);
       for(int i=1 ;i<ratings.length;i++) {
           if(ratings[i] > ratings[i-1]) {
               candy[i] = candy[i-1] + 1;
           }
       }

       for(int i = ratings.length-1 ;i>0;i--) {
           if(ratings[i-1] > ratings[i]) {
               candy[i-1] = Math.max(candy[i-1], candy[i] + 1);
           }
       }
        System.out.println(Arrays.toString(candy));

       int total = 0;
       for(Integer n : candy) {
           total+=n;
       }
       return total;
    }
}
