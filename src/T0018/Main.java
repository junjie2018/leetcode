package T0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().fourSum(new int[]{
                1, 0, -1, 0, -2, 2
        }, 0));
    }
}

/**
 * 超出时间限制
 */
class Solution {

    private int[] nums;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        this.nums = nums;

        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) continue;
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            fourSumCore(tmp, target - nums[i], i, 0);
            pre = nums[i];
        }

        return result;
    }

    private void fourSumCore(List<Integer> list, int target, int index, int step) {
        if (step == 3) {
            if (target == 0) result.add(list);
            return;
        }

        int pre = Integer.MIN_VALUE;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == pre) continue;
            ArrayList<Integer> tmp = new ArrayList<>(list);
            tmp.add(nums[i]);
            fourSumCore(tmp, target - nums[i], i, step + 1);
            pre = nums[i];
        }
    }
}

class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;

                int left = j + 1, right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]) ;
                    } else {
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }
            }
        }
        return result;
    }
}