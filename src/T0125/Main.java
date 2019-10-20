package T0125;

public class Main {
    public static void main(String[] args) {
        new Solution().isPalindrome("A man, a plan, a canal: Panama");
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        if (s.length() == 0) return true;

        s = s.toLowerCase();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
