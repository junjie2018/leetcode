package T0080;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(
                CommonUtils.createInt1a("[1,1,1,2,2,3]")
        ));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {

        int idx = 0;
        boolean idxCountIsTwo = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[idx]) {
                if (!idxCountIsTwo) {
                    idxCountIsTwo = true;
                    nums[++idx] = nums[i];
                }
            } else {
                idxCountIsTwo = false;
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }
}
