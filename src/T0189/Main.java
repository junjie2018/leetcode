package T0189;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        while (--k >= 0) {
            move(nums);
        }
    }

    private void move(int[] nums) {
        int tmp = nums[nums.length - 1];
        System.arraycopy(nums, 0, nums, 1, nums.length - 1);
        nums[0] = tmp;
    }
}

