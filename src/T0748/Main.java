package T0748;

import Common.CommonUtils;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestCompletingWord(
                "1s3 PSt",
                CommonUtils.createString1a("[\"step\",\"steps\",\"stripe\",\"stepple\"]")
        ));
    }
}

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        int[] map = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char aChar = licensePlate.charAt(i);
            if (aChar >= 'a' && aChar <= 'z') {
                map[aChar - 'a']++;
            }
            if (aChar >= 'A' && aChar <= 'Z') {
                map[aChar - 'A']++;
            }
        }

        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            if (equals(Arrays.copyOf(map, map.length), word)) {
                return word;
            }
        }

        return null;
    }

    private boolean equals(int[] map, String b) {
        for (int i = 0; i < b.length(); i++) {
            if (map[b.charAt(i) - 'a'] != 0) {
                map[b.charAt(i) - 'a']--;
            }
        }
        for (int value : map) {
            if (value != 0) return false;
        }
        return true;
    }
}