package T0066;

import Common.CommonUtils;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().plusOne(CommonUtils.createInt1a(
                "[9,9,9]"
        )));
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1; // 进位
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i];
            digits[i] = (cur + c) % 10;
            c = (cur + c) / 10;
        }

        if (c == 1) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = c;
            return result;
        }

        return digits;
    }
}
