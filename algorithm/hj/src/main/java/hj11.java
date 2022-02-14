import java.util.Scanner;

public class hj11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder0 = new StringBuilder();
        StringBuilder builder = new StringBuilder();

        String str = scanner.nextLine().trim();
        for(int i = str.length() - 1;i>=0;i-- ) {
            char c =str.charAt(i);
                builder.append(c);
        }

        System.out.println(builder);
    }
 }
