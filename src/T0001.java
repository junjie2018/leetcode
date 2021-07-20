import Common.CommonUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T0001 {

    public static void main(String[] args) {
        CommonUtils.show(
                new T0001().new Solution().twoSum(
                        CommonUtils.createIntArrayFromString("[2,5,5,11]"),
                        10));
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            return twoSum03(nums, target);
        }

        private int[] twoSum01(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            throw new RuntimeException("Wrong");
        }

        private int[] twoSum02(int[] nums, int target) {

            int[] original = Arrays.copyOf(nums, nums.length);

            Arrays.sort(nums);

            int left = 0, right = nums.length - 1;

            while (left != right) {
                if (nums[left] + nums[right] < target) {
                    ++left;
                } else if (nums[left] + nums[right] > target) {
                    --right;
                } else {
                    int[] result = new int[2];
                    for (int i = 0; i < original.length; i++) {
                        if (nums[left] == original[i]) {
                            result[0] = i;
                            break;
                        }
                    }
                    for (int i = original.length - 1; i >= 0; i--) {
                        if (nums[right] == original[i]) {
                            result[1] = i;
                            break;
                        }
                    }

                    return result;
                }
            }
            throw new RuntimeException("Wrong");
        }

        private int[] twoSum03(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                } else {
                    map.put(nums[i], i);
                }
            }
            throw new RuntimeException("Wrong");
        }
    }
}
