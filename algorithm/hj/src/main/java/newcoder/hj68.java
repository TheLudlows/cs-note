package newcoder;

import java.util.*;

public class hj68 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            int sort = Integer.parseInt(scanner.nextLine());
            Student[] students = new Student[n];
            for (int i = 0; i < n; i++) {
                String[] arr = scanner.nextLine().split(" ");
                students[i] = new Student(arr[0], Integer.parseInt(arr[1]));
            }

            Arrays.sort(students, (s1, s2) -> {
                if (sort == 1) {
                   return s1.score.compareTo(s2.score);
                } else {
                   return s2.score.compareTo(s1.score);
                }
            });
            for (Student s : students) {
                System.out.println(s.name + " " + s.score);
            }
        }
    }

    static class Student {
        String name;
        Integer score;

        public Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }

}
