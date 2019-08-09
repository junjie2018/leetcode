package T1105;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

/*
    这段话是解题的核心：
        1.需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。
        2.例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。

    这段话是说，你只需要考虑将编号为i的书放在第m层，还是将i、i-1、i-2等书放在第2层，不存在说将这本书插到其他层中（非常关键）

    // 12345

    // 1234
    // 5

    // 123
    // 45

 */

class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < books.length + 1; i++) {
            int maxHeight = 0;
            int leftWidth = shelf_width;

            for (int j = i - 1; j >= 0; j--) {
                leftWidth -= books[j][0];
                maxHeight = Math.max(maxHeight, books[j][1]);
                if (leftWidth >= 0) {
                    dp[i] = Math.min(dp[i], dp[j] + maxHeight);
                }
            }
        }

        return dp[books.length];
    }
}
