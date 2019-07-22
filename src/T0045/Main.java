package T0045;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{0}));
    }
}

class Solution {
    public int jump(int[] nums) {
        int[] canReachPoint = new int[nums.length];
        canReachPoint[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            canReachPoint[i] = i + nums[i] > canReachPoint[i - 1] ? i + nums[i] : canReachPoint[i - 1];
        }

        int point = 0, count = 0;
        while (true) {
            if (point >= nums.length - 1) {
                break;
            }
            count++;
            point = canReachPoint[point];
        }
        return count;
    }
}