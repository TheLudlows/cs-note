package nc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hj94 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] arr = scanner.nextLine().split(" ");
            Map<String,Integer> map = new HashMap();
            for(String s : arr) {
                map.put(s, 0);
            }
            int m = Integer.parseInt(scanner.nextLine());
            String[] votes = scanner.nextLine().split(" ");

            int inv = 0;
            for(String v: votes) {
                Integer count;
                if((count = map.get(v)) != null) {
                    map.put(v, count+1);
                } else {
                    inv ++;
                }
            }
            for(String s : arr) {
                System.out.println(s + " : " + map.get(s));
            }
            System.out.println("Invalid : " + inv );

        }

    }
}
