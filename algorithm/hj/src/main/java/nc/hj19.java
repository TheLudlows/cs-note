package nc;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class hj19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Error, Integer> count = new HashMap<>();
        Queue<Error> queue = new ArrayDeque<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            int idx = arr[0].lastIndexOf("\\");
            String key = arr[0].substring(idx);
            while (key.length() > 16) {
                key = key.substring(1);
            }
            Error error = new Error(key, Integer.parseInt(arr[1]));
            if (!count.containsKey(error)) {
                count.put(error, 1);
                if (queue.size() == 8) {
                    queue.poll();
                }
                queue.offer(error);
            } else {
                int c = count.get(error);
                c++;
                count.put(error, c);
            }
        }

        while(!queue.isEmpty()) {
            Error err = queue.poll();
            System.out.print(err.file +" ");
            System.out.print(err.count +" ");
            System.out.print(count.get(err));
            System.out.println();
        }
    }
    static class Error{
        String file;
        int count;

        public Error(String file, int count) {
            this.file = file;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Error error = (Error) o;
            return count == error.count && Objects.equals(file, error.file);
        }

        @Override
        public int hashCode() {
            return Objects.hash(file, count);
        }
    }
}
