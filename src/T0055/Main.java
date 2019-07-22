package T0055;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution3().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}

class Solution {

    public boolean canJump(int[] nums) {

        return canJumpCore(nums, 0);

    }

    private boolean canJumpCore(int[] nums, int curPoint) {
        int len = nums[curPoint];

        if (curPoint + len >= nums.length - 1) {
            return true;
        }

        for (int i = len; i > 0; i--) {
            if (canJumpCore(nums, curPoint + i)) return true;
        }

        return false;
    }

}

class Solution2 {

    public boolean canJump(int[] nums) {

        int[] canReachPoint = new int[nums.length];
        canReachPoint[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            canReachPoint[i] = i + nums[i] > canReachPoint[i - 1] ? i + nums[i] : canReachPoint[i - 1];
        }

        int point = 0;
        while (true) {
            if (canReachPoint[point] >= nums.length - 1) {
                return true;
            }
            if (canReachPoint[point] <= point) {
                return false;
            }
            point = canReachPoint[point];
        }
    }
}

class Solution3 {

    public boolean canJump(int[] nums) {
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= right) {
                right = i;
            }
        }
        return right == 0;
    }
}