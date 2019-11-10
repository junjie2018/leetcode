package T0696;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countBinarySubstrings("00110"));
    }
}

class Solution {
    public int countBinarySubstrings(String s) {
        int fir = 0, sec = 0;
        while (sec < s.length() && s.charAt(sec) == s.charAt(fir)) {
            ++sec;
        }

        int res = 0;

        int idx = sec;
        while (idx < s.length()) {
            while (idx < s.length() && s.charAt(idx) == s.charAt(sec)) {
                ++idx;
            }

            res += Math.min(idx - sec, sec - fir);
            fir = sec;
            sec = idx;
        }

        return res;
    }
}
