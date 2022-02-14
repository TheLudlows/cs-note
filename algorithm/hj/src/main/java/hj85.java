import java.util.Scanner;

public class hj85 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            int max = 0;
            for (int i = 0; i < line.length() - 1; i++) {
                int l1 = longgest(chars, i, i);
                int l2 = longgest(chars, i, i + 1);
                max = Math.max(l2, Math.max(max, l1));
            }
            System.out.println(max);
        }
    }

    public static int longgest(char[] arr, int left, int right) {
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
