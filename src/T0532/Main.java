package T0532;

import Common.CommonUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findPairs(
                CommonUtils.createInt1a("[-1,0,0,1,0,0,-1]"),
                1
        ));
    }
}

class Solution {

    public static final int FLAG = Integer.MAX_VALUE;

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 0;
        int preI = FLAG;
        for (int i = 0; i < nums.length; i++) {
            if (preI != FLAG && nums[i] == preI) {
                continue;
            }

            int preJ = FLAG;
            for (int j = i + 1; j < nums.length; j++) {
                if (preJ != FLAG && nums[j] == preJ) {
                    continue;
                }

                if (nums[j] - nums[i] == k) count++;


                preJ = nums[j];
            }

            preI = nums[i];
        }

        return count;
    }
}
