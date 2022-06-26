package lcof2;

import java.util.Arrays;

public class p17 {
    public String minWindow(String s, String t) {
        String result = null;
        int[] map = new int[128];

        for(char c : t.toCharArray()) {
            map[c] +=1;
        }

        int[] curMap = new int[128];


        int l = 0,r = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            if(map[c] == 0) {
                r++;

                continue;
            }
            curMap[c]+=1;
            while(contain(curMap, map)) {
                if(r - l + 1 < result.length() || s == null) {
                    result = s.substring(l, r+1);
                }
                char leftC = s.charAt(l);
                if(map[leftC] != 0) {
                    curMap[leftC]-=1;
                }
                l++;
            }
            r++;
        }
        return result;

    }

    public boolean contain(int[] arr1, int[] arr2) {
        for(int i=0;i<arr1.length;i++) {
            if(arr1[i] < arr2[i]) {
                return  false;
            }
        }
        return true;
    }
}
