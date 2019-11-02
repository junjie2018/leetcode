package T0485;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxLen = 0;

        int len = 0;
        for (int num : nums) {
            if (num == 0) {
                if (len > maxLen) maxLen = len;
                len = 0;
            } else {
                len++;
            }
        }
        if (len > maxLen) maxLen = len;
        return maxLen;
    }
}
