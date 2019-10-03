package T0986;

import Common.CommonUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().intervalIntersection(
                CommonUtils.create2s("[[0,2],[5,10],[13,23],[24,25]]"),
                CommonUtils.create2s("[[1,5],[8,12],[15,24],[25,26]]")
        ));
    }
}

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int idx = 0;
        int a = 0, b = 0;
        int[][] result = new int[2000][2];
        while (a < A.length && b < B.length) {
            int aLeft = A[a][0], aRight = A[a][1];
            int bLeft = B[b][0], bRight = B[b][1];

            if (aRight < bLeft) {
                a++;
                continue;
            }
            if (bRight < aLeft) {
                b++;
                continue;
            }

            result[idx][0] = aLeft > bLeft ? aLeft : bLeft;

            if (aRight > bRight) {
                result[idx++][1] = bRight;
                b++;
            } else {
                result[idx++][1] = aRight;
                a++;
            }
        }

        return Arrays.copyOf(result, idx);
    }
}
