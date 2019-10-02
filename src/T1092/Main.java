package T1092;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestCommonSupersequence("cab", "abac"));
    }
}

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];


        for (int i = 0; i < str1.length(); i++) {
            char aChar = str1.charAt(i);
            for (int j = 0; j < str2.length(); j++) {
                char bChar = str2.charAt(j);
                int m = i + 1, n = j + 1;
                dp[m][n] = aChar == bChar ? dp[m - 1][n - 1] + 1 : Math.max(dp[m][n - 1], dp[m - 1][n]);
            }
        }


        int i = str1.length() - 1;
        int j = str2.length() - 1;
        StringBuilder result = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if (str1.charAt(i) == str2.charAt(j)) {
                result.append(str1.charAt(i));
                i--;
                j--;
            } else {
                int m = i + 1, n = j + 1;
                if (dp[m][n] == dp[m - 1][n]) {
                    result.append(str1.charAt(i));
                    i--;
                } else {
                    result.append(str2.charAt(j));
                    j--;
                }
            }
        }
        while (i >= 0) {
            result.append(str1.charAt(i));
            i--;
        }
        while (j >= 0) {
            result.append(str2.charAt(j));
            j--;
        }

        return result.reverse().toString();
    }
}