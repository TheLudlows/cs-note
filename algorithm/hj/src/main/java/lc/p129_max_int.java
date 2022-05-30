package lc;

import java.util.Arrays;
import java.util.Comparator;

public class p129_max_int {
    public String largestNumber(int[] nums) {

        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(e1,e2) -> (e2+e1).compareTo(e1+e2));
        StringBuilder sb = new StringBuilder();
        for(String s: str) {
            sb.append(s);
        }
        if(sb.charAt(0) == '0') {
            return "0";
        }
            return  sb.toString();
    }
}
