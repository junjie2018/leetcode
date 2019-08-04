package T0003;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().lengthOfLongestSubstring("abcabcbb"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];

        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }

        int i = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        while (i < s.length()) {
            if (map[s.charAt(i)] == -1) {
                count++;
                map[s.charAt(i)] = i;
                i++;
            } else {
                if (count > max) {
                    max = count;
                }

                count = 0;
                i = map[s.charAt(i)] + 1;
                for (int j = 0; j < map.length; j++) {
                    map[j] = -1;
                }
            }
        }
        if (count > max) {
            max = count;
        }
        return max;
    }
}

/**
 * 使用滑动窗口解题
 */
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];

        int low = 0, high = 0;
        int max = Integer.MIN_VALUE;
        while (high < s.length()) {
            if (map[s.charAt(high)] == 0) {
                map[s.charAt(high)] = 1;
                high++;
            } else {
                max = Math.max(max, high - low);

                while (low < high && s.charAt(low) != s.charAt(high)) {
                    map[s.charAt(low++)] = 0;
                }
                map[s.charAt(low++)] = 0;
            }
        }
        max = Math.max(max, high - low);
        return max;
    }
}
