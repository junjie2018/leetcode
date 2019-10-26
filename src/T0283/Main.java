package T0283;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public void moveZeroes(int[] nums) {

        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
