package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p2241_atm {
}


class ATM {

    Map<Integer, Integer> map = new HashMap<>();

    public ATM() {

    }

    public void deposit(int[] banknotesCount) {
        for (int i : banknotesCount) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count+1);
        }
    }

    public int[] withdraw(int amount) {
        List<Integer> ret = new ArrayList<>();
        int count;
        while (amount > 0) {
            if(amount >= 500 && (count = map.getOrDefault(500, 0)) > 0) {
                map.put(500, count-1);
                ret.add(500);
                amount-=500;
            } else if(amount >= 200 && (count = map.getOrDefault(200, 0)) > 0) {
                map.put(200, count-1);
                ret.add(200);
                amount-=200;
            }else if(amount >= 100 && (count = map.getOrDefault(100, 0)) > 0) {
                map.put(100, count-1);
                ret.add(100);
                amount-=100;
            } else if(amount >= 50 && (count = map.getOrDefault(50, 0)) > 0) {
                map.put(50, count-1);
                ret.add(50);
                amount-=50;
            }else if(amount >= 20 && (count = map.getOrDefault(20, 0)) > 0) {
                map.put(20, count-1);
                ret.add(20);
                amount-=20;
            }

            if(amount == 0) {
                return ret.stream().mapToInt(i->i).toArray();
            }
        }
        return new int[]{-1};
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */