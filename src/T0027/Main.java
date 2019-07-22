package T0027;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
                fast++;
            } else {
                count++;
                fast++;
            }
        }
        return nums.length - count;
    }
}
