package nc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class hj14 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        // 这样读int
        int n = Integer.parseInt(scanner.nextLine());
        //int n = scanner.nextInt();
        List<String> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine().trim());
        }

        list = list.stream().sorted().collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
    }
}