package lc;

public class p1109_hangban {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0];
            int end = bookings[i][1];
            int seat = bookings[i][2];
            for (int j = start; j <= end; j++) {
                arr[j - 1] += seat;
            }
        }
        return arr;
    }

    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] arr = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0];
            int end = bookings[i][1];
            int seat = bookings[i][2];
            arr[start - 1] += seat;
            if (end != n) {
                arr[end] -= seat;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }
}
