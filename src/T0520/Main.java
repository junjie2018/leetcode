package T0520;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("Leetcode"));
    }
}

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;

        boolean firstAlpheIsUpper =
                word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';

        boolean hasLowerAlpha = false;
        boolean hasUpperAlpha = false;
        for (int i = 1; i < word.length(); i++) {
            char aChar = word.charAt(i);
            if (aChar >= 'a' && aChar <= 'z') {
                if (hasUpperAlpha) return false;
                hasLowerAlpha = true;
            } else {
                if (hasLowerAlpha) return false;
                hasUpperAlpha = true;
            }
        }
        return firstAlpheIsUpper || !hasUpperAlpha;
    }
}
