package lc;


import java.util.*;

public class MT2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int _n = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i; j < str.length(); j++) {
                Character c = str.charAt(j);
                Integer n = map.get(c);
                if (n == null) {
                    n = 1;
                } else {
                    n +=1;
                }
                map.put(c,n);
                max = Math.max(max,n);
                if (max > (j-i+1)/2) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
