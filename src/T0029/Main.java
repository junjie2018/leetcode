package T0029;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().divide(10, 3));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {

        // 处理特殊值
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        // 优化处理
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -dividend;
        }

        // 处理符号
        int symbol = 1;
        long dd = dividend, ds = divisor;
        if (dd < 0) {
            dd = -dd;
            symbol = -symbol;
        }
        if (ds < 0) {
            ds = -ds;
            symbol = -symbol;
        }

        // 核心逻辑
        int sum = 0;
        long i = dd, j = ds;
        while (i >= j) {
            int count = 1;
            while ((j << 1) <= i) {
                j = j << 1;
                count = count << 1;
            }
            i = i - j;
            j = ds;
            sum += count;
        }
        return sum * symbol;
    }
}

class Solution2 {
    public int divide(int dividend, int divisor) {

        // 处理特殊值
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        // 优化处理
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -dividend;
        }

        // 处理符号
        int symbol = 1;
        long dd = dividend, ds = divisor;
        if (dd < 0) {
            dd = -dd;
            symbol = -symbol;
        }
        if (ds < 0) {
            ds = -ds;
            symbol = -symbol;
        }

        // 核心逻辑
        int sum = 0;
        long i = dd, j = ds;
        while (i >= j) {
            int shift = 0;
            while ((j << shift) <= i) {
                shift++;
            }
            i = i - (j << (shift - 1));
            sum += 1 << (shift - 1);
        }
        return sum * symbol;
    }
}