package lcof2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p65 {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (e1,e2) -> e2.length() - e1.length());
        String result = "";
        System.out.println(Arrays.toString(words));
        for(int i=0;i<words.length;i++) {
            String s = words[i] + "#";
            if(!result.contains(s)) {
                result += s;
            }
        }
        return  result.length();
    }
    public int minimumLengthEncoding2(String[] words) {
        Set<String> good = new HashSet<String>(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word: good) {
            ans += word.length() + 1;
        }
        return ans;
    }
}
