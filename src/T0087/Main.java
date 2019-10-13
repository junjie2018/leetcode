package T0087;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().isScramble("abcde", "caebd"));
        System.out.println(new Solution().isScramble("aabb", "abab"));
//        System.out.println(new Solution2().isScramble("abb", "bab"));
    }
}

// 下图是字符串 s1 = "great" 的一种可能的表示形式 我没有注意到可能两个字
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (!match(s1, s2)) return false;
        return isScrambleCore(s1, s2);
    }

    private boolean isScrambleCore(String a, String b) {

        if (a.length() == 2 || a.length() == 1) return true;

        int mid = a.length() / 2;

        String a1, a2, b1, b2;

        a1 = a.substring(0, mid);
        a2 = a.substring(mid, a.length());

        if (a.length() % 2 == 0) {
            b1 = b.substring(0, mid);
            b2 = b.substring(mid, b.length());
            if (match(a1, b1) && match(a2, b2)) {
                if (isScrambleCore(a1, b1) && isScrambleCore(a2, b2)) return true;
            }
            if (match(a1, b2) && match(a2, b1)) {
                if (isScrambleCore(a1, b2) && isScrambleCore(a2, b1)) return true;
            }
        } else {
            b1 = b.substring(0, mid);
            b2 = b.substring(mid, b.length());
            if (match(a1, b1) && match(a2, b2)) {
                if (isScrambleCore(a1, b1) && isScrambleCore(a2, b2)) return true;
            }
            b1 = b.substring(0, mid + 1);
            b2 = b.substring(mid + 1, b.length());
            if (match(a1, b2) && match(a2, b1)) {
                if (isScrambleCore(a1, b2) && isScrambleCore(a2, b1)) return true;
            }
        }
        return false;
    }

    private boolean match(String a, String b) {
        int len = a.length();
        int[] mapA = new int[26], mapB = new int[26];
        for (int i = 0; i < len; i++) {
            mapA[a.charAt(i) - 'a']++;
            mapB[b.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (mapA[i] != mapB[i]) return false;
        }
        return true;
    }
}

class Solution2 {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.equals(s2)) return true;

        int len = s1.length();

        int[] map = new int[26];
        for (int i = 0; i < len; i++) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i))) return true;
        }
        return false;
    }
}