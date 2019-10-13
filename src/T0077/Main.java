package T0077;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}

class Solution {
    private int n;
    private int k;
    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        this.result = new ArrayList<>();

        combineCore(new ArrayList<>(), 0);

        return result;
    }

    private void combineCore(List<Integer> list, int idx) {
        if (list.size() >= k) {
            result.add(list);
            return;
        }

        for (int i = idx + 1; i <= n; i++) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(i);
            combineCore(tmp, i);
        }
    }


}