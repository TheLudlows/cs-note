package lc;

public class p006_str_n_convert {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        // 方向标记
        boolean dir = true;
        // 当前行号，如果0 向下，如果最大 向上
        int line = 0;
        for (int i = 0; i < s.length(); i++) {
            sb[line].append(s.charAt(i));
            if (line == 0) {
                dir = true;
            }
            if (line == numRows - 1) {
                dir = false;
            }
            if (dir) {
                line++;
            } else {
                line--;
            }
        }
        StringBuilder sbAll = new StringBuilder();
        for (int i = 0; i < sb.length; i++) {
            sbAll.append(sb[i]);
        }
        return sbAll.toString();
    }
}


