package T0119;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int k = 0; k <= rowIndex; k++) {
            ans.add(combination(rowIndex, k));
        }
        return ans;
    }

    private int combination(int N, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int) res;
    }
}


