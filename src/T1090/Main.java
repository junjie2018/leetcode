package T1090;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        new Solution().largestValsFromLabels(
                new int[]{5, 4, 3, 2, 1},
                new int[]{1, 3, 3, 3, 2},
                3,
                2
        );
    }
}

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        List<Tuple> tuples = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            tuples.add(new Tuple(values[i], labels[i]));
        }

        tuples.sort((a, b) -> Integer.compare(b.value, a.value));

        int sum = 0;
        int numUse = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Tuple item : tuples) {
            Integer key = item.label;
            if (!map.containsKey(key) || map.get(key) < use_limit) {
                sum += item.value;
                if (++numUse >= num_wanted) break;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return sum;
    }

    static class Tuple {
        int value;
        int label;

        public Tuple(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}