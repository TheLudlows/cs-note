import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hj92 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            List<String> list = new ArrayList<>();
            int i = 0;
            int max = 0;
            while (i < str.length()) {
                int j = i;
                while(j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                    j++;
                }
                if (j - i >= max && j - i > 0) {
                    String sub = str.substring(i, j);
                    max = Math.max(sub.length(), max);
                    List<String> newlist = new ArrayList<>();
                    for(int k = 0; k < list.size();k++) {
                        if(list.get(k).length() >= max) {
                            newlist.add(list.get(k));
                        }
                    }
                    newlist.add(sub);
                    list = newlist;
                }
                i = j;
                i++;
            }

            for (String s : list) {
                System.out.print(s);
            }
            System.out.println("," + max);
        }
    }
}
