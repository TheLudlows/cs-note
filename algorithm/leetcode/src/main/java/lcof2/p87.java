package lcof2;

import java.util.ArrayList;
import java.util.List;

public class p87 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        func(s, 0, res,  cur);
        return res;
    }

    private void func(String s, int start, List<String> res, List<String> cur) {
        if(cur.size() == 4) {
            if (start == s.length()) {
                res.add(String.join(".", cur));
            }
            return;
        }

        for(int i=1;i<=3;i++) {
            if(start+i> s.length()) {
                continue;
            }
            String str = s.substring(start, start+i);
            if(str.startsWith("0") && str.length() > 1) {
                continue;
            }
            if(Integer.parseInt(str) > 255 ) {
                continue;
            }
            cur.add(str);
            func(s, start+i, res, cur);
            cur.remove(cur.size()-1);
        }

    }
}
