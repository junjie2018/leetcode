package T0171;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("AAA"));
    }
}

class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(s.length() - 1 - i) - 'A' + 1;

            sum += val * Math.pow(26, i);
        }
        return sum;
    }
}