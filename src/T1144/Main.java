package T1144;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().movesToMakeZigzag(
//                CommonUtils.createInt1a("[1,2,3]")
                CommonUtils.createInt1a("[9,6,1,6,2]")
        ));
    }
}

class Solution {
    public int movesToMakeZigzag(int[] nums) {

        int len = nums.length;

        int evenSteps = 0;
        int oddSteps = 0;
        for (int i = 0; i < len; i++) {

            int left = i - 1 >= 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i + 1 < len ? nums[i + 1] : Integer.MAX_VALUE;
            int target = Math.min(left, right);

            if (nums[i] >= target) {
                // 偶数通过减一，使奇数形成锯齿
                if (i % 2 == 0) {
                    evenSteps += (nums[i] - target) + 1;
                }
                // 奇数通过减一，使偶数形成锯齿
                else {
                    oddSteps += (nums[i] - target) + 1;
                }
            }
        }

        return Math.min(evenSteps, oddSteps);
    }
}
