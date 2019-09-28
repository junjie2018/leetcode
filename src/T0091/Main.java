package T0091;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("00"));
    }
}

/*
    可以运行，但是需要300ms，不是很能忍受
 */
class Solution {
    private int count = 0;

    public int numDecodings(String s) {
        numDecodingsCore(s, 0);
        return count;
    }

    private void numDecodingsCore(String s, int idx) {
        while (idx < s.length()) {
            int cur = s.charAt(idx) - '0';
            if (cur == 0) {
                return;
            }
            if (cur == 1 && idx + 1 < s.length()) {
                numDecodingsCore(s, idx + 2);
            }
            if (cur == 2 && idx + 1 < s.length()) {
                int next = s.charAt(idx + 1) - '0';
                if (next >= 0 && next <= 6) {
                    numDecodingsCore(s, idx + 2);
                }
            }
            idx++;
        }
        count++;
    }
}

class Solution2 {
    private HashMap<String, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        return backtrack(s);
    }

    private int backtrack(String s) {
        if (map.containsKey(s)) return map.get(s);
        if (s.length() > 0 && s.charAt(0) == '0') return 0;
        if (s.length() <= 1) return 1;

        int w = backtrack(s.substring(1));
        int t = Integer.parseInt(s.substring(0, 2));
        if (t <= 26) {
            w += backtrack(s.substring(2));
        }
        map.put(s, w);
        return w;
    }
}
