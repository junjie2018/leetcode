package T0680;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean validPalindrome(String s) {
        return validPalindromeCore(s, 0, s.length() - 1);
    }

    private boolean validPalindromeCore(String s, int i, int j) {
        if (s.length() == 0 || s.length() == 1) return true;

        while (s.charAt(i) == s.charAt(j) && i < j) {
            ++i;
            --j;
        }

        if (i == j || i - 1 == j) return true;

        return isPalindromic(s, i + 1, j)
                || isPalindromic(s, i, j - 1);
    }

    private boolean isPalindromic(String s, int i, int j) {
        while (s.charAt(i) == s.charAt(j) && i < j) {
            ++i;
            --j;
        }

        return i == j || i - 1 == j;
    }
}
