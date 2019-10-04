package T0046;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().permute(CommonUtils.createInt1a("[1,2,3]")));
    }
}

class Solution {
    private int[] nums;
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        result = new ArrayList<>();

        permuteCore(new ArrayList<>(), new boolean[nums.length]);

        return result;
    }

    private void permuteCore(ArrayList<Integer> integers, boolean[] flags) {
        if (integers.size() >= nums.length) {
            result.add(integers);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                boolean[] tmpFlags = Arrays.copyOf(flags, flags.length);
                tmpFlags[i] = true;
                ArrayList<Integer> tmpIntegers = new ArrayList<>(integers);
                tmpIntegers.add(nums[i]);
                permuteCore(tmpIntegers, tmpFlags);
            }
        }
    }
}

class Solution2 {

    private int len;
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {

        this.len = nums.length;
        this.result = new ArrayList<>();

        ArrayList<Integer> integers = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }

        permuteCore(integers, 0);

        return result;
    }

    private void permuteCore(ArrayList<Integer> integers, int n) {
        if (n >= len) {
            result.add(integers);
            return;
        }


        int nValue = integers.get(n);
        permuteCore(integers, n + 1); // i = n时直接写，可以保证循环简洁
        for (int i = n + 1; i < len; i++) {
            ArrayList<Integer> tmp = new ArrayList<>(integers);
            tmp.set(n, tmp.get(i));
            tmp.set(i, nValue);
            permuteCore(tmp, n + 1);
        }

    }
}