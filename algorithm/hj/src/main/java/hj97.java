import java.util.Scanner;

public class hj97 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            double sum = 0;
            int neg = 0;
            int pos = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if(arr[i] < 0) {
                    neg ++;
                }
                if(arr[i] > 0) {
                    pos++;
                    sum += arr[i];
                }
            }

            double avg = sum / pos;
            System.out.println(neg + " " + String.format("%.1f", avg));

        }
    }
}
