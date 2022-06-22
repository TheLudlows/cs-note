package lcof2;

import java.util.TreeMap;

public class p58 {
    class MyCalendar {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendar() {

        }
        public boolean book(int start, int end) {
            Integer floor = map.floorKey(start);
            Integer ceiling = map.ceilingKey(start);

            if((floor != null  && map.get(floor) > start) || (ceiling != null && end > ceiling)) {
                return false;
            }
            map.put(start, end);
            return true;
        }
    }
}
