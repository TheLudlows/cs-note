package leetcode;

public class p043_chengfa {
    public String multiply(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        while (i>=0 && j >=0) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';

            int m = n1 * n2 + pre;
            if(m > 9) {
                pre = m/10;
            } else {
                pre = 0;
            }
            m = m % 10;
            sb.append(m);
            i--;
            j--;
        }
        while(i>=0) {
            sb.append(num1.charAt(i));
            i--;
        }
        while(j>=0) {
            sb.append(num1.charAt(j));
            j--;
        }
        return sb.reverse().toString();
    }
}
