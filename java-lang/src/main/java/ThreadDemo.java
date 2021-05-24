public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("111111");

            }
        });
        t.start();
        t.interrupt();
        System.out.println(1);
    }
}
