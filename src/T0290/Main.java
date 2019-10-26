package T0290;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("aba", "dog cat cat"));
    }
}

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;

        HashMap<Character, String> p2s = new HashMap<>();
        HashMap<String, Character> s2p = new HashMap<>();

        int len = strs.length;
        for (int i = 0; i < len; i++) {
            Character p = pattern.charAt(i);
            String s = strs[i];

            if (p2s.containsKey(p)) {
                if (!s2p.containsKey(s) || !s2p.get(s).equals(p)) {
                    return false;
                }
            } else {
                if (s2p.containsKey(s)) {
                    return false;
                }

                p2s.put(p, s);
                s2p.put(s, p);
            }
        }
        return true;
    }
}
