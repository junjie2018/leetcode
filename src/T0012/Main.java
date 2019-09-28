package T0012;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(4));
    }
}

class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        // 处理千分位
        int a = num / 1000;
        for (int i = 0; i < a; i++) {
            result.append("M");
        }

        // 处理百分位
        num %= 1000;
        if (num >= 900) {
            result.append("CM");
        } else if (num >= 500) {
            result.append("D");
            a = (num - 500) / 100;
            for (int i = 0; i < a; i++) {
                result.append("C");
            }
        } else if (num >= 400) {
            result.append("CD");
        } else {
            a = num / 100;
            for (int i = 0; i < a; i++) {
                result.append("C");
            }
        }

        // 处理十分位
        num %= 100;
        if (num >= 90) {
            result.append("XC");
        } else if (num >= 50) {
            result.append("L");
            a = (num - 50) / 10;
            for (int i = 0; i < a; i++) {
                result.append("X");
            }
        } else if (num >= 40) {
            result.append("XL");
        } else {
            a = num / 10;
            for (int i = 0; i < a; i++) {
                result.append("X");
            }
        }

        // 处理个位
        num %= 10;
        if (num >= 9) {
            result.append("IX");
        } else if (num >= 5) {
            result.append("V");
            a = num - 5;
            for (int i = 0; i < a; i++) {
                result.append("I");
            }
        } else if (num >= 4) {
            result.append("IV");
        } else {
            a = num;
            for (int i = 0; i < a; i++) {
                result.append("I");
            }
        }
        return result.toString();
    }
}
