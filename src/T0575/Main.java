package T0575;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);

        int count = 0;
        int pre = Integer.MAX_VALUE;
        for (int candy : candies) {
            if (candy == pre) continue;
            ++count;
            pre = candy;
        }

        return count > candies.length / 2 ? candies.length / 2 : count;
    }
}