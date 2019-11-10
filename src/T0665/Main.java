package T0665;

import Common.CommonUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().checkPossibility(CommonUtils.createInt1a(
//                "[4,2,1]"
//                "[2,3,3,2,4]"
//                "[-1,4,2,3]"
                "[3,4,2,3]"
        )));
    }
}

class Solution {
    public boolean checkPossibility(int[] nums) {
        int ppre = Integer.MIN_VALUE, pre = nums[0], count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < pre) {
                if (count == 1) {
                    return false;
                }

                if (nums[i] >= ppre) {
                    pre = nums[i];
                }

                count = 1;
                continue;

            }
            ppre = pre;
            pre = nums[i];
        }
        return true;
    }
}