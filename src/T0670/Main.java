package T0670;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().maximumSwap(9937));
    }
}

/*
    这个方案并不能解决问题，9937就没有办法解决
 */
class Solution {
    public int maximumSwap(int num) {
        if (num == 0) return 0;

        int maxVal = Integer.MIN_VALUE;
        int maxIdx = 0;
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++) {
            if ((numStr.charAt(i) - '0') > maxVal) {
                maxVal = numStr.charAt(i) - '0';
                maxIdx = i;
            }
        }
        char[] numChars = numStr.toCharArray();
        char tmp = numChars[0];
        numChars[0] = numChars[maxIdx];
        numChars[maxIdx] = tmp;

        return Integer.parseInt(String.valueOf(numChars));
    }
}

class Solution2 {
    public int maximumSwap(int num) {
        if (num == 0) return 0;

        String numStr = String.valueOf(num);
        List<Integer> digits = new ArrayList<>(8);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            digits.add(digit);
            map.put(digit, i);
        }

        digits.sort(Comparator.reverseOrder());

        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            if (digit != digits.get(i)) {
                // 完成交换
                char[] numChars = numStr.toCharArray();
                char tmp = numChars[i];
                numChars[i] = numChars[map.get(digits.get(i))];
                numChars[map.get(digits.get(i))] = tmp;

                return Integer.parseInt(String.valueOf(numChars));
            }
        }
        return num;
    }
}