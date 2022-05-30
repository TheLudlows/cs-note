package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p406_paidui {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (e1,e2) -> {
            int cmp = Integer.compare(e2[0], e1[0]);
            if(cmp == 0) {
                return Integer.compare(e1[1],e2[1]);
            } else {
                return  cmp;
            }

        });
        List<int[]> list = new LinkedList<int[]>();
        for(int[] arr : people) {
            if(arr[1] == list.size()) {
                list.add(arr);
            } else {
                list.add(arr[1], arr);
            }
        }

        int[][] res = new int[people.length][];
        for(int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
