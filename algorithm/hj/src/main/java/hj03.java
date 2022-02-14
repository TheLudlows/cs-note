import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class hj03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            Set<Integer> set = new HashSet<>();
            int n = scanner.nextInt();
            for(int i=0;i<n;i++) {
                set.add(scanner.nextInt());
            }
            List<Integer> list = set.stream().sorted().collect(Collectors.toList());
            for(Integer i : list) {
                System.out.println(i);
            }
        }
    }
}

