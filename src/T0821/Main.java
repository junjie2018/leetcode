package T0821;

public class Main {
    public static void main(String[] args) {
        new Solution().shortestToChar("loveleetcode", 'e');
    }
}

class Solution {
    public static final int INF = 10000;

    public int[] shortestToChar(String S, char C) {
        int[] l2r = new int[S.length()], r2l = new int[S.length()];

        int l2r_p_idx = -1, r2l_p_idx = -1;
        for (int i = 0; i < S.length(); i++) {
            // l2r
            l2r_p_idx = S.charAt(i) == C ? i : l2r_p_idx;
            l2r[i] = l2r_p_idx == -1 ? INF : i - l2r_p_idx;

            // r2l
            r2l_p_idx = S.charAt(S.length() - 1 - i) == C ? S.length() - 1 - i : r2l_p_idx;
            r2l[S.length() - 1 - i] = r2l_p_idx == -1 ? INF : r2l_p_idx - S.length() + 1 + i;
        }

        int[] res = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            res[i] = Math.min(l2r[i], r2l[i]);
        }
        return res;
    }
}