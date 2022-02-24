import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hj74 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            List<String> list = new ArrayList();
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<line.length();) {
                char c = line.charAt(i);
                if(c!=' ' && c != '"') {
                    builder.append(c);
                } else {
                    if(c == ' ') {
                        list.add(builder.toString());
                        builder.setLength(0);
                    } else {
                        i++;
                        while (line.charAt(i) !='"' ) {
                            builder.append(line.charAt(i));
                            i++;
                        }
                        list.add(builder.toString());
                        builder.setLength(0);
                        i++;
                    }

                }
                i++;
            }
            if(builder.length() != 0) {
                list.add(builder.toString());
            }
            System.out.println(list.size());
           for(String s: list) {
               System.out.println(s);
           }
        }
    }
}
