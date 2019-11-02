package T0561;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
