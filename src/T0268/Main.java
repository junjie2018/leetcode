package T0268;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {
            result ^= i;
        }

        return result;
    }
}