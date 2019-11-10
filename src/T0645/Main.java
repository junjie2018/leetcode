package T0645;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().findErrorNums(CommonUtils.createInt1a(
//                "[2,2]"
//                "[1,2,2,4]"
//                "[3,2,2]"
                "[3,3,1]"
        )));
    }
}

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int point = Math.abs(nums[i]) - 1;
            if (nums[point] < 0) {
                res[0] = point + 1;
                continue;
            }
            nums[point] = -nums[point];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }
}
