package T0008;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().myAtoi("  0000000000012345678"));
    }
}

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;

        char sign = '+';
        boolean beginAcceptChar = false;
        boolean beginAcceptNum = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char aChar = str.charAt(i);
            if (aChar == ' ') {
                if (beginAcceptChar) break;
            } else if (aChar == '+' || aChar == '-') {
                if (beginAcceptChar) break;
                beginAcceptChar = true;
                sign = aChar;
            } else if (aChar >= '0' && aChar <= '9') {
                if (!beginAcceptChar) beginAcceptChar = true;
                if (aChar == '0' && sb.length() == 0) continue;
                if (sb.length() > 10) {
                    if (sign == '-') return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                sb.append(aChar);
            } else {
                if (beginAcceptChar) break;
                return 0;
            }
        }

        // 没有数字字符
        if (sb.length() == 0) {
            return 0;
        }

        String result = sb.insert(0, sign).toString();
        long num = Long.parseLong(result);
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) num;
    }
}