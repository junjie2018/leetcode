package T0047;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(CommonUtils.create("[2,2,1,1]")));
    }
}

class Solution {
    private int len;
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {

        this.len = nums.length;
        this.result = new ArrayList<>();

        ArrayList<Integer> integers = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }

        permuteUniqueCore(integers, 0);

        return result;
    }

    private void permuteUniqueCore(ArrayList<Integer> integers, int n) {
        if (n >= len) {
            result.add(integers);
            return;
        }

        HashMap<Integer, Boolean> flags = new HashMap<>();

        int nValue = integers.get(n);
        permuteUniqueCore(integers, n + 1); // i = n时直接写，可以保证循环简洁
        flags.put(nValue, true);
        for (int i = n + 1; i < len; i++) {
            if (!flags.containsKey(integers.get(i))) {
                ArrayList<Integer> tmp = new ArrayList<>(integers);
                tmp.set(n, tmp.get(i));
                tmp.set(i, nValue);
                flags.put(integers.get(i), true);
                permuteUniqueCore(tmp, n + 1);
            }
        }
    }
}