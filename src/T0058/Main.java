package T0058;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("He llo Wo5rld "));
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean containNoAlpha = false;
        boolean beginCount = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char aChar = s.charAt(i);
            if (aChar == ' ') {
                if (!containNoAlpha && beginCount) return len;

                len = 0;
                beginCount = false;
                containNoAlpha = false;
            } else {
                len++;
                if (aChar >= 'A' && aChar <= 'Z' || aChar >= 'a' && aChar <= 'z') {
                    beginCount = true;
                } else {
                    containNoAlpha = true;
                }
            }
        }
        return containNoAlpha ? 0 : len;
    }
}

