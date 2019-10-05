package T0503;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution2().nextGreaterElements(
//                CommonUtils.createInt1a("[1,2,1]")
                CommonUtils.createInt1a("[5,4,3,2,1]")
//                CommonUtils.createInt1a("[1,2,3,4,3]")
        ));
    }
}

// 理解错题意了
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(set);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size() - 1; i++) {
            map.put(list.get(i), list.get(i + 1));
        }
        map.put(list.get(list.size() - 1), -1);

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(nums[i]);
        }

        return result;
    }
}

class Solution2 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int len = nums.length;

        int[] l2r = new int[len], r2l = new int[len];

        l2r[0] = nums[0];

        for (int i = 1; i < len; i++) {
            l2r[i] = Math.max(l2r[i - 1], nums[i]);
        }

        r2l[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            r2l[i] = Math.max(r2l[i + 1], nums[i]);
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            // 右边存在结果，从i+1遍历到len-1可得到结果
            if (i + 1 < len && nums[i] < r2l[i + 1]) {
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i]) {
                        result[i] = nums[j];
                        break;
                    }
                }
                continue;
            }
            // 左边存在结果，从i-1遍历到0可得到结果
            if (i - 1 >= 0 && nums[i] < l2r[i - 1]) {
                for (int j = 0; j <= i; j++) {
                    if (nums[j] > nums[i]) {
                        result[i] = nums[j];
                        break;
                    }
                }
                continue;
            }
            result[i] = -1;
        }

        return result;
    }
}
