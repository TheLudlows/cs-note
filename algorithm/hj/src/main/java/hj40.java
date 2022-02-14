import java.util.Scanner;

public class hj40 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            int letter = 0;
            int num = 0;
            int space = 0;
            int other = 0;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    letter++;
                } else if (c >= 'A' && c <= 'Z') {
                    letter++;
                } else if (c >= '0' && c <= '9') {
                    num++;
                } else if (c == ' ') {
                    space++;
                } else {
                    other++;
                }
            }

            System.out.println(letter);
            System.out.println(space);
            System.out.println(num);
            System.out.println(other);
        }
    }
}
