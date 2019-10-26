package T0392;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        int beginIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            beginIdx = t.indexOf(aChar, beginIdx + 1);
            if (beginIdx < 0) return false;
        }
        return true;
    }
}
