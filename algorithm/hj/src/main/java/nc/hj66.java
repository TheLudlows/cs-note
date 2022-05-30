package nc;

import java.util.*;

public class hj66 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String other = "unknown command";
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delete", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        List<List<String>> keys = new ArrayList();

        for (String s : map.keySet()) {
            List<String> ss = new ArrayList();
            for (String str : s.split(" ")) {
                ss.add(str);
            }
            keys.add(ss);
        }

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] cmm = line.split(" ");
            String val = other;
            int find = 0;
            for (List<String> key : keys) {
                if(startsWith(key, cmm)) {
                    val = map.get(String.join(" ",key));
                    find++;
                }
            }
            if(find > 1) {
                val = other;
            }
            System.out.println(val);
        }
    }

    public static boolean startsWith(List<String> key, String[] cmm) {
        if (key.size() != cmm.length) {
            return false;
        }
        for (int i = 0; i < cmm.length; i++) {
            if (!key.get(i).startsWith(cmm[i])) {
                return false;
            }
        }
        return true;
    }
}
