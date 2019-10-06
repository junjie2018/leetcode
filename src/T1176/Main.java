package T1176;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().dietPlanPerformance(
//                CommonUtils.createInt1a("[3,2]"),
//                2,
//                0,
//                1
                CommonUtils.createInt1a("[6,5,0,0]"),
                2,
                1,
                5
        ));
    }
}

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int T = 0;
        int res = 0;
        int left = 0, right = 0;

        while (right < calories.length) {
            T += calories[right];
            if (right - left + 1 > k) {
                T -= calories[left];
                left++;
            }
            if (right - left + 1 == k) {
                if (T > upper) ++res;
                if (T < lower) --res;
            }
            right++;
        }

        return res;
    }
}
