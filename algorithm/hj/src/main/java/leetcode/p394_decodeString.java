package leetcode;

public class p394_decodeString {
    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                n = n*10 + c - '0';
                i++;
            } else if(c=='[') {
                int j = i;
                int count = 0;
                for(;j<s.length();j++) {
                    if(s.charAt(j) == '[') {
                        count++;
                    }
                    if(s.charAt(j) == ']') {
                        count--;
                    }
                    if(count == 0) {
                        break;
                    }
                }
                String str = decodeString(s.substring(i+1,j));
                for(int k=0;k<n;k++) {
                    sb.append(str);
                }
                i = j+1;
                n=0;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new p394_decodeString().decodeString("10[a]");
        System.out.println(s);
    }
}
