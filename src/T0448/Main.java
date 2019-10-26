package T0448;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public void swap(int[] nums, int idx1, int idx2) {
        if (idx1 != idx2) {
            nums[idx1] = nums[idx1] ^ nums[idx2];
            nums[idx2] = nums[idx1] ^ nums[idx2];
            nums[idx1] = nums[idx1] ^ nums[idx2];
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int l = nums.length;
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < l; i++) {
            if (nums[i] != i + 1) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
