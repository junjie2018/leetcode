package T0057;

import Common.CommonUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().insert(new int[][]{
                //[[1,3],[6,9]]
//                {1, 3},
//                {6, 9}
                // [[1,2],[3,5],[6,7],[8,10],[12,16]]
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16},

        }, new int[]{4, 8}));
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        boolean intervalIsDisposed = false;
        boolean leftIsDisposed = false;
        int[][] result = new int[1024][];

        int index = 0;
        int[] intervalWithLeft = new int[2];
        int left = newInterval[0], right = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {

            int[] tmp = intervals[i];

            // 如果新增区间已经被处理了，直接将当前的结点添加到 result 中
            if (intervalIsDisposed) {
                result[index++] = tmp;
                continue;
            }


            if (!leftIsDisposed) {
                if (right < tmp[0]) {
                    result[index++] = new int[]{left, right};
                    result[index++] = tmp;
                    intervalIsDisposed = true;
                    continue;
                }
                if (left > tmp[1]) {
                    result[index++] = tmp;
                    continue;
                }
                if (left <= tmp[1]) {
                    intervalWithLeft[0] = Math.min(left, tmp[0]);
                    intervalWithLeft[1] = right;
                    result[index++] = intervalWithLeft;
                    leftIsDisposed = true;

                    if (right <= tmp[1]) {
                        intervalWithLeft[1] = tmp[1];
                        intervalIsDisposed = true;
                    }
                }
            }

            if (leftIsDisposed) {
                if (right < tmp[0]) {
                    intervalIsDisposed = true;
                    result[index++] = tmp;
                } else if (right > tmp[1]) {

                } else {
                    intervalWithLeft[1] = tmp[1];
                    intervalIsDisposed = true;
                }
            }
        }

        if (!intervalIsDisposed && !leftIsDisposed) {
            result[index++] = newInterval;
        }

        return Arrays.copyOf(result, index);
    }
}

class Solution2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        boolean leftIsDisposed = false;
        boolean[] intervalsFlags = new boolean[intervals.length];

        int left = newInterval[0], right = newInterval[1];
        int[] intervalWithLeft = new int[2];
        for (int i = 0; i < intervals.length; i++) {

            int[] tmp = intervals[i];

            if (!leftIsDisposed && left <= tmp[1]) {
                tmp[0] = Math.min(left, tmp[0]);
                leftIsDisposed = true;

                if (right <= tmp[1]) {
                    break;
                }

                intervalWithLeft = tmp;
                intervalWithLeft[1] = right;
                continue;
            }

            if (leftIsDisposed) {
                if (right < tmp[0]) {
                    intervalWithLeft[1] = right;
                    break;
                } else if (right > tmp[1]) {
                    intervalsFlags[i] = true;
                } else {
                    intervalWithLeft[1] = tmp[1];
                    intervalsFlags[i] = true;
                    break;
                }
            }
        }

        // 如果最后一个节点都被忽略了，则 intervalWithLeft 的右边界为right
        intervalWithLeft[1] = intervalsFlags[intervalsFlags.length - 1] ? right : intervalWithLeft[1];

        int index = 0;
        int[][] result = new int[1024][];
        for (int i = 0; i < intervalsFlags.length; i++) {
            if (!intervalsFlags[i]) {
                result[index++] = intervals[i];
            }
        }

        return Arrays.copyOf(result, index);
    }
}
