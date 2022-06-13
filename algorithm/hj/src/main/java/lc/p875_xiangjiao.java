package lc;

public class p875_xiangjiao {
    public int minEatingSpeed(int[] piles, int h) {
        if (h < piles.length) {
            return 0;
        }
        int slow = 1;
        int high = 0;

        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }
        int ret = 0;
        while (slow < high) {
            int mid = slow + (high - slow) / 2;

            int time = getTime(mid, piles);
            if (time <= h) {
                ret = mid;
                high = mid;
            } else {
                slow = mid + 1;
            }
        }
        return ret;
    }

    private int getTime(int speed, int[] piles) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] + speed - 1) / speed;
        }
        return time;
    }
}
