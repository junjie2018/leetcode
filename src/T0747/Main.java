package T0747;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        for (int num : nums) {
            if (num != max && max < 2 * num) return -1;
        }

        return maxIdx;
    }
}