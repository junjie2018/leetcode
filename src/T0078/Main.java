package T0078;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    private int[] nums;
    private int len;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.len = nums.length;

        subsetsCore(new ArrayList<Integer>(), 0);

        return result;
    }

    private void subsetsCore(ArrayList<Integer> lists, int i) {
        if (i >= len) {
            result.add(lists);
            return;
        }

        ArrayList<Integer> tmp = new ArrayList<>(lists);
        tmp.add(nums[i]);

        subsetsCore(tmp, i + 1);
        subsetsCore(lists, i + 1);
    }
}
