package T0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}

class Solution {
    private int[] candidates;
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.result = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSum2Core(new ArrayList<>(), 0, target);

        return this.result;
    }

    private void combinationSum2Core(List<Integer> list, int index, int target) {
        for (int i = index; i < candidates.length; i++) {
            int curValue = candidates[i];
            int preValue = i == index ? -1 : candidates[i-1];
            if (curValue == preValue) {
                // 与当前值相同的值已经被处理，跳过该值
                continue;
            }
            if (target - curValue == 0) {
                list.add(curValue);
                result.add(list);
                return;
            }
            if (target - curValue < 0) {
                return;
            }
            if (target - curValue > 0) {
                ArrayList<Integer> tmp = new ArrayList<>(list);
                tmp.add(curValue);
                combinationSum2Core(tmp, i+1, target - curValue);
            }
        }
    }
}
