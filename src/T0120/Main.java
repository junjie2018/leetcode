package T0120;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    public static final int INF = 100000;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] tmp = new int[n];
        tmp[0] = triangle.get(0).get(0);


        for (int i = 1; i < n; i++) {
            int left = INF, right;
            for (int j = 0; j < i; j++) {
                right = tmp[j];
                tmp[j] = Math.min(left, right) + triangle.get(i).get(j);
                left = right;
            }
            tmp[i] = left + triangle.get(i).get(i);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (tmp[i] < min) {
                min = tmp[i];
            }
        }

        return min;
    }
}