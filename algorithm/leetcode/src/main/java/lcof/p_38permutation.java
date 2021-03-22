package lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p_38permutation {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> list = new ArrayList<>();
        StringBuffer cur = new StringBuffer();
        boolean[] vit = new boolean[chars.length];
        trace(chars, list, cur, vit);
        String[] ret = new String[list.size()];

        for(int i=0;i<ret.length;i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    private void trace(char[] chars, List<String> list, StringBuffer cur, boolean[] vit) {

        if (cur.length() == chars.length) {
            list.add(cur.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            //if(!vit[i]) {
                System.out.println(cur.toString());
                if(i > 0 && chars[i] == chars[i-1] /*&& vit[i-1]*/) {
                    continue;
                }
               // vit[i] = true;
                cur.append(chars[i]);
                trace(chars,list,cur,vit);
                cur.deleteCharAt(cur.length()-1);
               // vit[i] = false;
           // }
        }
    }

    public static void main(String[] args) {
       String[] arr = new p_38permutation().permutation("aab");
        System.out.println(Arrays.toString(arr));
    }


}
