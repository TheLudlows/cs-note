package lc;


import java.util.*;

public class p1709 {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Character> c1 = new ArrayList<>();
        List<Character> c2 = new ArrayList<>();
        if(s1 == s2) {
            return true;
        } else if(s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i) ) {
                c1.add(s1.charAt(i));
                c2.add(s2.charAt(i));
            }
        }
        c1.sort(Comparator.naturalOrder());
        c2.sort(Comparator.naturalOrder());

        return c1.size() == c2 .size() && c1.size() <=2 && c1.equals(c2);

    }
}
