package T0075;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        new Solution().sortColors(CommonUtils.createInt1a(
                "[2,0,2,1,1,0]"
        ));
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int c1 = 0, c2 = 0, c3 = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    ++c1;
                    break;
                case 1:
                    ++c2;
                    break;
            }
        }

        int s1 = c1, s2 = c1 + c2;
        for (int i = 0; i < nums.length; i++) {
            if (i < s1) nums[i] = 0;
            else if (i < s2) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
