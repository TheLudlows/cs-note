import java.util.Scanner;

public class hj62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(Integer.bitCount(n));
        }
    }


}
