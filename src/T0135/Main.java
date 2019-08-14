package T0135;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{
//                1, 0, 2
//                1, 2, 2
//                1, 3, 2, 2, 1
//                1, 2, 87, 87, 87, 2, 1
                1, 3, 4, 5, 2
        }));
    }
}

class Solution {
    public int candy(int[] ratings) {

        int sum = 0;
        int preCandies = 0;
        int tailIdx = 0, topIdx = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[topIdx]) {
                topIdx++;
                continue;
            }

            int length = topIdx - tailIdx + 1;
            if (tailIdx == 0 || ratings[tailIdx] == ratings[tailIdx - 1]) {
                sum += length;
                preCandies = length;
            } else {
                preCandies = preCandies >= length ? preCandies + 1 : length;
                sum += preCandies;
            }

            for (int len = length - 1; len >= 1; len--) {
                sum += len;
                preCandies = len;
            }

            topIdx = i;
            tailIdx = i;
        }
        int length = topIdx - tailIdx + 1;
        for (int len = 1; len < length; len++) {
            sum += len;
        }
        if (tailIdx == 0 || ratings[tailIdx] == ratings[tailIdx - 1]) {
            sum += length;
        } else {
            sum += preCandies >= length ? preCandies + 1 : length;
        }
        return sum;
    }
}
