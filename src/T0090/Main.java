package T0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }
}

class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    private int len;
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        this.nums = nums;
        this.len = nums.length;

        Arrays.sort(nums);

        subsetsWithDupCore(new ArrayList<>(), 0);

        return result;
    }

    private void subsetsWithDupCore(ArrayList<Integer> list, int n) {

        if (n >= len) {
            result.add(list);
            return;
        }


        int curNum = nums[n];

        // 计算当前字符的数量
        int count = 0;
        for (int i = n; i < len && nums[i] == curNum; i++) {
            count++;
        }

        ArrayList<Integer> tmp = new ArrayList<>(list);
        for (int i = 1; i <= count; i++) {
            tmp.add(curNum);
            subsetsWithDupCore(new ArrayList<>(tmp), n + count);
        }

        subsetsWithDupCore(list, n + count);
    }
}
