package T0219;

import Common.CommonUtils;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new Solution().containsNearbyDuplicate(CommonUtils.createInt1a("[1,2,3,1,2,3]"), 2);
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
