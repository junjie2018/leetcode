package T0081;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        new Solution2().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0);
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        return true;
    }
}

@SuppressWarnings("all")
class Solution2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);

        return Arrays.binarySearch(nums, target) >= 0;
    }
}
