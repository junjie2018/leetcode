package T0857;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Solution().mincostToHireWorkers(
//                CommonUtils.createInt1a("[3,1,10,10,1]"),
//                CommonUtils.createInt1a("[4,8,2,2,7]"),
//                3
                CommonUtils.createInt1a("[10,20,5]"),
                CommonUtils.createInt1a("[70,50,30]"),
                2
        );
    }
}

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {

        int len = quality.length;

        Tuple[] tuples = new Tuple[len];

        for (int i = 0; i < len; i++) {
            tuples[i] = new Tuple(quality[i], wage[i]);
        }

        Arrays.sort(tuples, Comparator.comparingDouble(a -> a.ratio));

        int sumQuality = 0;
        double ans = Double.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (Tuple tuple : tuples) {
            sumQuality += tuple.quality;
            pq.offer(tuple.quality);
            if (pq.size() > K) {
                sumQuality -= pq.poll();
            }
            if (pq.size() == K) {
                ans = Math.min(ans, sumQuality * tuple.ratio);
            }
        }

        return ans;
    }

    private static class Tuple {
        int quality;
        int wage;
        double ratio;


        public Tuple(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double) wage / quality;
        }
    }
}
