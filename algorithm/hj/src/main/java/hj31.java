import java.util.Scanner;

public class hj31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if( (c <='z' && c >='a') || (c >='A' && c <='Z')) {
                buf.append(c);
            } else {
                buf.append(' ');
            }
        }
        String[] arr = buf.toString().split(" ");
        StringBuilder out = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--) {
            out.append(arr[i].trim() ).append(" ");
        }
        out.deleteCharAt(out.length()-1);
        System.out.println(out);
    }
}
