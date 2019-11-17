package T0728;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().selfDividingNumbers(
                1, 22
        ));
    }
}

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isNaturalNumber(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isNaturalNumber(int num) {
        int tmp = num;
        while (tmp != 0) {
            int cur = tmp % 10;
            if (cur == 0) return false;
            if (num % cur != 0) return false;
            tmp = tmp / 10;
        }
        return true;
    }
}
