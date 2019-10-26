package T0350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new Solution().intersect(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int aNums1 : nums1) {
            map.put(aNums1, map.getOrDefault(aNums1, 0) + 1);
        }

        int idx = 0;
        int[] res = new int[1024];
        for (int aNums2 : nums2) {
            if (map.containsKey(aNums2) && map.get(aNums2) != 0) {
                res[idx++] = aNums2;
                map.put(aNums2, map.get(aNums2) - 1);
            }
        }

        return Arrays.copyOf(res, idx);
    }
}
