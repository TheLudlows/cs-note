import java.util.Scanner;

public class hj38 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double h = Double.parseDouble(scanner.nextLine());
        Double total = 0.0;

        for (int i = 0; i < 5; i++) {
            total += h *1.5;
            h = h / 2;
        }
        System.out.println(total);
        System.out.println(h);
    }
}
