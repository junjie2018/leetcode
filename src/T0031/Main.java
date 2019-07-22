package T0031;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1};
        new Solution().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    public void nextPermutation(int[] nums) {

        // 交换
        int head = -1;
        out:
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // 需要交换
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        head = i + 1;
                        break out;
                    }
                }
            }
        }

        // 排序
        head = head == -1 ? 0 : head;
        Arrays.sort(nums, head, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution2 {
    public void nextPermutation(int[] nums) {

        // 交换
        int head = -1;
        out:
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // 需要交换
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        head = i + 1;
                        break out;
                    }
                }
            }
        }

        // 排序
        head = head == -1 ? 0 : head;
        Arrays.sort(nums, head, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}