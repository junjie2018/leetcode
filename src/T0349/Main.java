package T0349;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int idx = 0;
        int[] res = new int[result.size()];
        for (Integer integer : result) {
            res[idx++] = integer;
        }

        return res;
    }
}
