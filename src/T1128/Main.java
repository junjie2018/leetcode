package T1128;

import Common.CommonUtils;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numEquivDominoPairs(
//                CommonUtils.createInt2a("[[1,1],[2,2],[1,1],[1,2],[1,2],[1,1]]")
                CommonUtils.createInt2a("[[2,1],[5,4],[3,7],[6,2],[4,4],[1,8],[9,6],[5,3],[7,4],[1,9],[1,1],[6,6],[9,6],[1,3],[9,7],[4,7],[5,1],[6,5],[1,6],[6,1],[1,8],[7,2],[2,4],[1,6],[3,1],[3,9],[3,7],[9,1],[1,9],[8,9]]")
        ));
    }
}

class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] stat = new int[10][10];

        for (int[] dominoe : dominoes) {
            if (dominoe[1] <= dominoe[0]) {
                stat[dominoe[1]][dominoe[0]]++;
            } else {
                stat[dominoe[0]][dominoe[1]]++;
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (stat[i][j] > 1) {
                    int n = stat[i][j];
                    sum += (n * (n - 1)) / 2;
                }
            }
        }

        return sum;
    }
}

// 超出时间限制了
class Solution2 {

    private int result;
    private int len;
    private int[][] dominoes;

    public int numEquivDominoPairs(int[][] dominoes) {
        this.len = dominoes.length;
        this.dominoes = dominoes;
        numEquivDominoPairsCore(0);
        return result;
    }

    private void numEquivDominoPairsCore(int idx) {
        if (idx >= len) return;
        int[] a = dominoes[idx];
        for (int i = idx + 1; i < len; i++) {
            int[] b = dominoes[i];
            if ((a[0] == b[0] && a[1] == b[1]) || (a[0] == b[1] && a[1] == b[0])) {
                result++;
            }
        }
        numEquivDominoPairsCore(idx + 1);
    }
}
