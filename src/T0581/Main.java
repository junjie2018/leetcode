package T0581;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{
//                2, 6, 4, 8, 10, 9, 15
//                1, 2, 3, 4
                1, 2, 4, 5, 3
        }));
    }
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {


        int leftIdx = -1;
        boolean leftFlag = false; // 标志目前是否产生乱序
        Deque<Integer> leftStack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!leftFlag) {
                if (leftStack.size() == 0) {
                    leftStack.push(i);
                    continue;
                }
                if (nums[i] > nums[leftStack.peek()]) {
                    leftStack.push(i);
                    continue;
                }
                if (nums[i] == nums[leftStack.peek()]) {
                    continue;
                }
                leftFlag = true;
                leftIdx = leftStack.poll();
            }

            while (leftStack.size() > 0 && nums[i] < nums[leftStack.peek()]) {
                leftIdx = leftStack.poll();
            }
        }


        int rightIdx = -1;
        boolean rightFlag = false; // 标志目前是否产生乱序
        Deque<Integer> rightStack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!rightFlag) {
                if (rightStack.size() == 0) {
                    rightStack.push(nums.length - 1);
                    continue;
                }
                if (nums[i] < nums[rightStack.peek()]) {
                    rightStack.push(i);
                    continue;
                }
                if (nums[i] == nums[rightStack.peek()]) {
                    continue;
                }
                rightFlag = true;
                rightIdx = rightStack.poll();
            }
            while (rightStack.size() > 0 && nums[i] > nums[rightStack.peek()]) {
                rightIdx = rightStack.poll();
            }
        }

        return rightIdx == leftIdx ? 0 : rightIdx - leftIdx + 1;
    }
}
