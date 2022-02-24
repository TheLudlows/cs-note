import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class hj16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            List<Tuple> list = new ArrayList<>();
            list.add(new Tuple());
            int amount = scanner.nextInt();
            int n = scanner.nextInt();
            for(int i = 0;i<n;i++) {
                int price = scanner.nextInt();
                int weight = scanner.nextInt();
                int parent = scanner.nextInt();
                list.add(new Tuple(price, weight, parent));
            }

            // 遍历 增加附属品
            int main = 0;
            List<Tuple> newList = new ArrayList<>();
            newList.add(new Tuple());
            for(int i=1;i<=n;i++) {
                Tuple t = list.get(i);
                if(t.parent != 0) {
                    Tuple parent = list.get(t.parent);
                    parent.attach.add(t);
                } else {
                    newList.add(t);
                    main++;
                }
            }
            list = newList;

            int[][] dp = new int[main+1][amount+1];
            for(int i=1;i<list.size();i++) {
                Tuple t = list.get(i);
                if(t.parent != 0) {
                    continue;
                }
                for(int j = 0;j<=amount;j++) {
                    dp[i][j] = dp[i-1][j];
                    if(j>= t.price) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-t.price] + t.weight * t.price);
                    }
                    if(t.attach.size() == 0) {
                        continue;
                    }
                    if(t.attach.size() > 0 ) {
                        Tuple t1 = t.attach.get(0);
                        if(j >= t.price + t1.price) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - t.price - t1.price] + t.weight * t.price + t1.price * t1.weight);
                        }
                    }
                    if(t.attach.size() > 1 ) {
                        Tuple t1 = t.attach.get(0);
                        Tuple t2 = t.attach.get(1);
                        if(j >= t.price + t2.price) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - t.price - t2.price] + t.weight * t.price + t2.price * t2.weight);
                        }
                        if(j >= t.price + t2.price + t1.price) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-t.price-t1.price - t2.price] + t.weight * t.price +  t1.price * t1.weight + t2.price * t2.weight);
                        }
                    }


                }
            }

            for(int i=0;i<dp.length;i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
            System.out.println(dp[main][amount]);
        }

    }

    static class Tuple {
        int price;
        int weight;
        List<Tuple> attach;
        int parent;

        public Tuple(int price, int weight, int parent) {
            this.price = price;
            this.weight = weight;
            this.parent = parent;
            attach = new ArrayList<>();
        }

        public Tuple() {
        }
    }

}
