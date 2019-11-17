package T0819;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.trim().toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));

        int pre = -1;
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) >= 'a' && paragraph.charAt(i) <= 'z') {
                if (pre == -1) pre = i;
            } else {
                if (pre != -1) {
                    String tmp = paragraph.substring(pre, i);
                    if (!set.contains(tmp)) map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                    pre = -1;
                }
            }
        }
        if (pre != -1) {
            String tmp = paragraph.substring(pre);
            if (!set.contains(tmp)) map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String res = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}
