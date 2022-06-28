package lcof2;

import java.util.ArrayList;
import java.util.List;

public class p85 {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n,0,0,new StringBuilder());
        return res;
    }

    private void dfs(int n, int open, int close, StringBuilder stringBuilder) {
        if(open + close == 2* n) {
            res.add(stringBuilder.toString());
            return;
        }
        if(open < n) {
            stringBuilder.append('(');
            dfs(n, open+1, close, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if(close < open) {
            stringBuilder.append(')');
            dfs(n, open, close+1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }
}
