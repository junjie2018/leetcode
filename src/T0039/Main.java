package T0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7).toString());
    }
}

class Solution {
    private int[] candidates;
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.result = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSumCore(new ArrayList<>(), 0, target);

        return result;
    }

    private void combinationSumCore(List<Integer> list, int index, int target) {
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] == 0) {
                list.add(candidates[i]);
                result.add(list);
                return;
            }
            if (target - candidates[i] < 0) {
                return;
            }
            if (target - candidates[i] > 0) {
                ArrayList<Integer> tmp = new ArrayList<>(list);
                tmp.add(candidates[i]);
                combinationSumCore(tmp, i, target - candidates[i]);
            }
        }
    }
}