package iv;

// 每分钟100
public class Limiter {
    long endTime;
    int count;
    static int window_size = 60 * 1000;

    public synchronized boolean acquire() {
        if (endTime == 0) {
            endTime = System.currentTimeMillis() + window_size;
        }

        if (System.currentTimeMillis() < endTime) {
            count++;
        } else {
            endTime = System.currentTimeMillis() + window_size;
            count = 0;
        }
        if (count <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Limiter limiter = new Limiter();
        for (int i = 0; i < 101; i++) {
            limiter.acquire();
        }
    }
}
