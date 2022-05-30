package lc;

import java.util.ArrayList;
import java.util.List;

public class p093_ip {

    public List<String> restoreIpAddresses(String s) {
        List<List<String>> list = new ArrayList();
        List<String> path = new ArrayList();
        findIp(s, 0,  list, path);
        List<String> res = new ArrayList();
        list.forEach(e -> res.add(String.join(".", e)));
        return res;
    }

    private void findIp(String s, int idx,  List<List<String>> list, List<String> path) {
        if(idx == s.length() && path.size() == 4) {
            list.add(new ArrayList(path));
        }
        if(idx == s.length()) {
            return;
        }
        for(int i=1;i<4;i++) {
            String strNum = s.substring(idx,idx+i);
            if(strNum.startsWith("0")) {
                break;
            }
            int n = Integer.parseInt(strNum);
            if(n > 255) {
                break;
            }
            path.add(strNum);
            findIp(s, idx+i, list, path);
            path.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("aa".substring(0,1));
    }
}
