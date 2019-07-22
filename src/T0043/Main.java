package T0043;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "456"));
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        /*
                    1 2 3 4 5   => num1
                  * 2 3 1 2 3   => num2
                  -------------
         */

        int[] tmp = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {

            int b = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {

                int a = num1.charAt(j) - '0';

                int idx = i + j + 1;
                tmp[idx - 1] = tmp[idx - 1] + (tmp[idx] + a * b) / 10;
                tmp[idx] = (tmp[idx] + a * b) % 10;
            }
        }

        boolean falg = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            if (falg || tmp[i] != 0) {
                falg = true;
                result.append(tmp[i]);
            }
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
