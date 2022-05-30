package nc;

import java.util.Scanner;

public class hj72 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            scanner.nextInt();
            for(int i=0;i<4;i++) {
                int x = 4 *i;
                int y = 25 - 7 * i;
                int z = 100 -x -y;
                System.out.println(x + " " + y + " " + z);
            }
        }
    }
}
