package T0056;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution4().merge(new int[][]{
                // [[1,3],[2,6],[8,10],[15,18]]
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18},
//                {1, 4},
//                {0, 4}
        }));
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {

        }

        List<List<Integer>> result = new ArrayList<>();

        int index = 1;
        int[] cur = intervals[0];
        while (index < intervals.length) {
            if (cur[1] >= intervals[index][0]) {
                cur[1] = intervals[index][1];
                index++;
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(cur[0]);
                tmp.add(cur[1]);
                result.add(tmp);
                cur = intervals[index];
            }
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(cur[0]);
        tmp.add(cur[1]);
        result.add(tmp);

        int[][] r = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            r[i] = new int[]{result.get(i).get(0), result.get(i).get(1)};
        }

        return r;
    }
}

class Solution2 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][];
        }


        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(intervals[i][0]);
            tmp.add(intervals[i][1]);
            lists.add(tmp);
        }

        lists.sort(Comparator.comparing(e -> e.get(0)));

        List<Integer> curList = lists.remove(0);
        while (lists.size() > 0) {
            List<Integer> tmp = lists.remove(0);
            if (curList.get(1).compareTo(tmp.get(0)) >= 0) {
                curList.set(1, Math.max(curList.get(1), tmp.get(1)));
            } else {
                results.add(curList);
                curList = tmp;
            }
        }
        results.add(curList);

        int[][] vals = new int[results.size()][];
        for (int i = 0; i < results.size(); i++) {
            vals[i] = new int[]{results.get(i).get(0), results.get(i).get(1)};
        }

        return vals;
    }
}


class Solution3 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

        int[][] vals = new int[1024][];
        int[] curArr = intervals[0];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            if (curArr[1] >= tmp[0]) {
                curArr[1] = Math.max(curArr[1], tmp[1]);
            } else {
                vals[index++] = curArr;
                curArr = tmp;
            }
        }
        vals[index++] = curArr;

        return Arrays.copyOf(vals, index);
    }
}

class Solution4 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][];
        }

//        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

//        int[][] vals = new int[1024][];
//        int[] curArr = intervals[0];
        int index = 0;
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            if (right >= tmp[0]) {
                right = Math.max(right, tmp[1]);
            } else {

                intervals[index][0] = left;
                intervals[index][1] = right;
                index++;

                left = tmp[0];
                right = tmp[1];
            }
        }
        intervals[index][0] = left;
        intervals[index][1] = right;
        index++;

        return Arrays.copyOf(intervals, index);
    }
}