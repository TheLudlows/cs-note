package leetcode;

import java.util.Arrays;

public class p820_bianma {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (e1, e2) -> Integer.compare(e2.length(), e1.length()));
        String sb = new String();
        for (String s : words) {
            if (sb.contains(s + "#")) {
                continue;
            } else {
                if (sb.length() == 0) {
                    sb = s + "#";
                } else {
                    sb = sb + s + "#";
                }

            }
        }
        return sb.length();
    }
}
