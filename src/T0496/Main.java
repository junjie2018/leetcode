package T0496;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().nextGreaterElement(new int[]{
                4, 1, 2
        }, new int[]{
                1, 3, 4, 2
        })));
    }
}

/**
 * 非常普通的解法
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean isFind = false;
            for (int j = 0; j < nums2.length; j++) {
                if (isFind) {
                    if (nums1[i] < nums2[j]) {
                        result[i] = nums2[j];
                        break;
                    }
                } else {
                    if (nums1[i] == nums2[j]) {
                        result[i] = -1;
                        isFind = true;
                    }
                }
            }
        }
        return result;
    }
}

/**
 * 用单调栈的解法来解，从右边的元素建栈，维护一栈可以
 */
class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                int curNum = stack.pop();
                int greaterNum = stack.isEmpty() ? -1 : stack.peek();
                map.put(curNum, greaterNum);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            int curNum = stack.pop();
            int greaterNum = stack.isEmpty() ? -1 : stack.peek();
            map.put(curNum, greaterNum);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }
}