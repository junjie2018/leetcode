package T1103;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().distributeCandies(60, 4));
    }
}

// 每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int around = (1 + num_people) * num_people / 2;

        int count = 0;
        while (candies >= around + num_people * num_people * count) {
            candies -= around + num_people * num_people * count;
            count++;
        }

        int[] result = new int[num_people];
        int preAround = num_people * count;
        for (int i = 0; i < num_people; i++) {
            int curNeed = preAround + i + 1;
            result[i] = (candies > curNeed ? curNeed : candies) + getSum(count - 1) * num_people + count * (i + 1);
            candies = candies > curNeed ? candies - curNeed : 0;
        }
        return result;
    }

    private int getSum(int count) {
        return count * (count + 1) / 2;
    }
}