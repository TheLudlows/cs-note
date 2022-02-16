import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class hj102 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int[] map = new int[256];
            for(int i=0;i<line.length();i++) {
                map[line.charAt(i)] ++;
            }
            List<Tuple> list = new ArrayList();
            for(int i=0;i<map.length;i++) {
                if(map[i] > 0) {
                    list.add(new Tuple((char) i, map[i]));
                }
            }
            Collections.sort(list, (e1,e2) -> {
                int r = Integer.compare(e2.n,e1.n);
                if(r == 0) {
                    return Character.compare(e1.c, e2.c);
                } else {
                    return r;
                }
            });
            for(Tuple t : list) {
                System.out.print(t.c);
            }
            System.out.println();
        }
    }

    static class Tuple{
        char c;
        int n;

        public Tuple(char c, int n) {
            this.c = c;
            this.n = n;
        }


    }
}
