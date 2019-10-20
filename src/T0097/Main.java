package T0097;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().isInterleave(
                "aabcc", "dbbca", "aadbbcbcac"
        ));
    }
}

/*
    超出时间限制了
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if ("".equals(s1)) return s2.equals(s3);
        if ("".equals(s2)) return s1.equals(s3);
        if ("".equals(s3)) return false;

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        char c3 = s3.charAt(0);

        if (c1 != c3 && c2 != c3) {
            return false;
        } else if (c1 == c3 && c2 == c3) {
            if (isInterleave(s1.substring(1), s2, s3.substring(1))) return true;
            if (isInterleave(s1, s2.substring(1), s3.substring(1))) return true;
        } else if (c1 == c3) {
            return isInterleave(s1.substring(1), s2, s3.substring(1));
        } else if (c2 == c3) {
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        } else {
            return false;
        }
        return false;
    }
}

class Solution2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }

        return dp[s2.length()][s1.length()];
    }
}
