package lcof2;

import java.util.ArrayList;
import java.util.List;

public class p86 {
    public String[][] partition(String s) {
        List<List<String>> res = new ArrayList();
        List<String> cur = new ArrayList();
        find(s, 0, res, cur);
        System.out.println(res.size());
        String[][] strs = new String[res.size()][];

        for (int i = 0; i < strs.length; i++) {
            strs[i] = new String[res.get(i).size()];
            for (int j = 0; j < strs[i].length; j++) {
                strs[i][j] = res.get(i).get(j);
            }
        }
        return strs;
    }

    private void find(String s, int start, List<List<String>> res, List<String> cur) {
        if (start >= s.length()) {
            res.add(new ArrayList(cur));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i+1);
            if(valid(str)) {
                cur.add(str);
                find(s, i+1,res, cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean valid(String str) {
        int i = 0;
        int j = str.length()-1;
        while(i<j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        new p86().partition("google");
    }
}
