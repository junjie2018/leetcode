package T0830;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
//        TreeMap<String, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int pre = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(pre)) {
                continue;
            }

            if (i - pre >= 3) {
                List<Integer> group = new ArrayList<>();
                group.add(pre);
                group.add(i - 1);
                res.add(group);
//                map.put(S.substring(pre, i), group);
            }
            pre = i;
        }

        if (S.length() - pre >= 3) {
            List<Integer> group = new ArrayList<>();
            group.add(pre);
            group.add(S.length() - 1);
            res.add(group);
//            map.put(S.substring(pre), group);
        }

//        return new ArrayList<>(map.values());
        return res;
    }
}