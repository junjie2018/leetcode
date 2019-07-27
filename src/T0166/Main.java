package T0166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(100, 3));
    }
}

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }


        boolean symbol = true;
        long num = numerator, den = denominator;

        if (numerator < 0) {
            num = -num;
            symbol = false;
        }

        if (den < 0) {
            den = -den;
            symbol = !symbol;
        }

        // 处理符号
        StringBuilder integers = new StringBuilder();
        if (!symbol) {
            integers.append("-");
        }

        // 处理整数部分
        if (num / den == 0) {
            integers.append("0");
        } else {
            while (num / den > 0) {
                integers.append(num / den);
                num = num % den;
            }
        }

        // 处理小数部分
        if (num == 0) {
            return integers.toString();
        } else {
            int index = 0;
            boolean isLoop = false;
            HashMap<Long, Integer> map = new HashMap<>();
            StringBuilder decimals = new StringBuilder();
            while (num != 0) {
                if (map.containsKey(num)) {
                    isLoop = true;
                    break;
                }
                map.put(num, index++);
                decimals.append(num * 10 / den);
                num = num * 10 % den;
            }
            if (isLoop) {
                decimals.insert(map.get(num), "(");
                decimals.append(")");
            }
            return integers.append(".").append(decimals).toString();
        }
    }
}
