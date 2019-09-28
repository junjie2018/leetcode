package T0583;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("plasma", "altruism"));
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            char aChar = word1.charAt(i);
            for (int j = 0; j < word2.length(); j++) {
                int m = i + 1, n = j + 1;
                char bChar = word2.charAt(j);

                dp[m][n] = aChar == bChar ? dp[m - 1][n - 1] + 1 : Math.max(dp[m][n - 1], dp[m - 1][n]);
            }
        }

        int maxMatch = Integer.MIN_VALUE;
        for (int[] row : dp) {
            for (int item : row) {
                if (item > maxMatch) maxMatch = item;
            }
        }
        return (word1.length() - maxMatch) + (word2.length() - maxMatch);
    }
}