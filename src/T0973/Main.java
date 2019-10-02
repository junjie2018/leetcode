package T0973;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Solution().kClosest(CommonUtils.create2s("[[1,3],[-2,2]]"), 2);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {

        List<Point> list = new ArrayList<>();

        for (int[] point : points) {
            list.add(new Point(point[0], point[1]));
        }

        list.sort(Comparator.comparingInt(a -> a.sum));

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point point = list.get(i);
            result[i][0] = point.x;
            result[i][1] = point.y;
        }

        return result;
    }

    private static class Point {
        int x;
        int y;
        int sum;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.sum = x * x + y * y;
        }
    }
}
