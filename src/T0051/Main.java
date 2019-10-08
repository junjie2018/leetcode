package T0051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(1));
    }
}

class Solution {
    private int n;
    private int[] result;
    private List<List<String>> out;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.result = new int[n];
        this.out = new ArrayList<>();
        solveNQueensCore(0, result, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return out;
    }

    private void solveNQueensCore(int row, int[] result, boolean[] t2b, boolean[] tl2br, boolean[] tr2bl) {
        if (row >= n) {
            List<String> tmp = new ArrayList<>();
            for (int i : result) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(i == j ? "Q" : ".");
                }
                tmp.add(sb.toString());
            }
            out.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            // 判断该列是否可以放置
            if (t2b[i]) continue;
            // 判断左右方向斜边是否可以放置
            int tl2brPoint = n + i - row - 1;
            if (tl2br[tl2brPoint]) continue;

            int tr2blPoint = i + row;
            if (tr2bl[tr2blPoint]) continue;

            int[] tmpResult = Arrays.copyOf(result, result.length);
            boolean[] tmpT2b = Arrays.copyOf(t2b, t2b.length);
            boolean[] tmpTl2br = Arrays.copyOf(tl2br, tl2br.length);
            boolean[] tmpTr2bl = Arrays.copyOf(tr2bl, tr2bl.length);

            tmpResult[row] = i;
            tmpT2b[i] = true;
            tmpTl2br[tl2brPoint] = true;
            tmpTr2bl[tr2blPoint] = true;

            solveNQueensCore(row + 1, tmpResult, tmpT2b, tmpTl2br, tmpTr2bl);
        }
    }
}
