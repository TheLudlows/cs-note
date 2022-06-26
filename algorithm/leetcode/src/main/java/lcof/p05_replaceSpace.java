package lcof;

public class p05_replaceSpace {
    public String replaceSpace(String s) {
       char[] chars =  s.toCharArray();
       StringBuffer buffer = new StringBuffer();

       for(char c : chars) {
           if (c == ' ') {
               buffer.append("%20");
           }else {
               buffer.append(c);
           }
       }
       return buffer.toString();
    }
}
