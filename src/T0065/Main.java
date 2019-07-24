package T0065;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isNumber("005047e+6"));
    }
}

class Solution {

    private String s;
    private int len;

    public boolean isNumber(String s) {
        s = s.trim();

        this.s = s;
        this.len = s.length();
        /*
            +/- 数字 . 数字 e +/- 数字 . 数字
         */

        return disposeStart(0);
    }

    // 处理启动器
    boolean disposeStart(int cur) {
        if (cur >= len) {
            return false;
        }

        if (s.charAt(cur) == '+' || s.charAt(cur) == '-') {
            // 将当前字符交给符号处理
            return disposeSymbolBeforeE(cur);
        }

        if (s.charAt(cur) == '.') {
            return disposeDecimalsBeforeEHead(cur);
        }

        if (isNumber(s.charAt(cur))) {
            return disposeNumberBeforeEPre(cur);
        }

        return false;
    }

    boolean disposeDecimalsBeforeEHead(int cur) {
        if (cur + 1 >= len) {
            return false;
        }

        if (isNumber(s.charAt(cur + 1))) {
            return disposeNumberBeforeEPost(cur + 1);
        }
        return false;
    }

    /**
     * 处理e前符号部分
     */
    boolean disposeSymbolBeforeE(int cur) {
        if (cur + 1 >= len) {
            return false;
        }

        if (isNumber(s.charAt(cur + 1))) {
            return disposeNumberBeforeEPre(cur + 1);
        }

        if (s.charAt(cur + 1) == '.') {
            return disposeDecimalsBeforeEHead(cur + 1);
        }

        return false;
    }

    /**
     * 处理e前数字部分
     */
    boolean disposeNumberBeforeEPre(int cur) {
        if (cur + 1 >= len) {
            return true;
        }

        // 模拟自旋转
        while (isNumber(s.charAt(cur + 1))) {
            cur = cur + 1;
            if (cur + 1 >= len) {
                return true;
            }
        }

        if (s.charAt(cur + 1) == '.') {
            return disposeDecimalsBeforeE(cur + 1);
        }

        if (s.charAt(cur + 1) == 'e') {
            return disposeE(cur + 1);
        }

        return false;
    }

    boolean disposeNumberBeforeEPost(int cur) {
        if (cur + 1 >= len) {
            return true;
        }

        // 模拟自旋转
        while (isNumber(s.charAt(cur + 1))) {
            cur = cur + 1;
            if (cur + 1 >= len) {
                return true;
            }
        }

        if (s.charAt(cur + 1) == 'e') {
            return disposeE(cur + 1);
        }

        return false;
    }

    boolean disposeDecimalsBeforeE(int cur) {
        if (cur + 1 >= len) {
            return true;
        }

        if (isNumber(s.charAt(cur + 1))) {
            return disposeNumberBeforeEPost(cur + 1);
        }

        if (s.charAt(cur + 1) == 'e') {
            return disposeE(cur + 1);
        }

        return false;
    }

    boolean disposeE(int cur) {
        if (cur + 1 >= len) {
            return false;
        }

        if (s.charAt(cur + 1) == '+' || s.charAt(cur + 1) == '-') {
            // 将当前字符交给符号处理
            return disposeSymbolAfterE(cur+1);
        }

        if (isNumber(s.charAt(cur + 1))) {
            return disposeNumberAfterEPre(cur+1);
        }

        return false;
    }

    boolean disposeSymbolAfterE(int cur) {
        if (cur + 1 >= len) {
            return false;
        }

        if (isNumber(s.charAt(cur + 1))) {
            return disposeNumberAfterEPre(cur + 1);
        }

        return false;
    }

    boolean disposeNumberAfterEPre(int cur) {
        if (cur + 1 >= len) {
            return true;
        }

        // 模拟自旋转
        while (isNumber(s.charAt(cur + 1))) {
            cur = cur + 1;
            if (cur + 1 >= len) {
                return true;
            }
        }

//        if (s.charAt(cur + 1) == '.') {
//            return disposeDecimalsAfterE(cur + 1);
//        }

        return false;
    }

    boolean disposeNumberAfterEPost(int cur) {
        if (cur + 1 >= len) {
            return true;
        }

        // 模拟自旋转
        while (isNumber(s.charAt(cur + 1))) {
            cur = cur + 1;
            if (cur + 1 >= len) {
                return true;
            }
        }

        return false;
    }

    private boolean disposeDecimalsAfterE(int cur) {
        if (cur + 1 >= len) {
            return false;
        }

        if (isNumber(s.charAt(cur + 1))) {
            return disposeNumberAfterEPost(cur + 1);
        }

        return false;
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

}
