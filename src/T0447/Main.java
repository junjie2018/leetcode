package T0447;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBoomerangs(
                CommonUtils.createInt2a("[[0,0],[1,0],[2,0]]")
        ));
    }
}


class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;

        int res = 0;
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                int xLen = points[j][0] - points[i][0], yLen = points[j][1] - points[i][1];
                int key = xLen * xLen + yLen * yLen;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (Integer count : map.values()) {
                if (count >= 2) {
                    res += count * (count - 1);
                }
            }
        }

        return res;
    }
}


/*
    想错了
 */
class Solution2 {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] point : points) {
            graph.computeIfAbsent(point[0], ArrayList::new).add(point[1]);
            graph.computeIfAbsent(point[1], ArrayList::new).add(point[0]);
        }

        int res = 0;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();

            Map<Integer, Integer> map = new HashMap<>();
            for (Integer edge : value) {
                int tmp = key * key + edge * edge;
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }

            for (Integer count : map.values()) {
                if (count >= 2) {
                    res += (count * (count - 1)) / 2;
                }
            }
        }

        return res / 2;
    }
}
