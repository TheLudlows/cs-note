package hj;

import java.util.ArrayList;
import java.util.List;

public class hj92 {

    public static void max_num(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int j = 1;
        int max = 0;
        while (j <str.length()) {
            while (str.charAt(j)<=57) {
                j++;
            }
            if(j - i >= max) {
                String sub = str.substring(i,j);
                for(int k = 0;i<list.size();k++) {
                    if(sub.length() > list.get(0).length()) {

                    }
                }
            }
        }
    }
}
