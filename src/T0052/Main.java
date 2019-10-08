package T0052;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private int n;
    private int count;
    private List<List<String>> out;


    public int totalNQueens(int n) {
        this.n = n;
        this.out = new ArrayList<>();
        totalNQueensCore(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return count;
    }


    private void totalNQueensCore(int row, boolean[] t2b, boolean[] tl2br, boolean[] tr2bl) {
        if (row >= n) {
            count++;
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

            boolean[] tmpT2b = Arrays.copyOf(t2b, t2b.length);
            boolean[] tmpTl2br = Arrays.copyOf(tl2br, tl2br.length);
            boolean[] tmpTr2bl = Arrays.copyOf(tr2bl, tr2bl.length);

            tmpT2b[i] = true;
            tmpTl2br[tl2brPoint] = true;
            tmpTr2bl[tr2blPoint] = true;

            totalNQueensCore(row + 1, tmpT2b, tmpTl2br, tmpTr2bl);
        }
    }
}
