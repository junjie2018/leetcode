package T0500;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Solution().findWords(CommonUtils.createString1a("[\"Hello\",\"Alaska\",\"Dad\",\"Peace\"]"));
    }
}

class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> char2Row = new HashMap<>();

        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";

        for (int i = 0; i < row1.length(); i++) {
            char2Row.put(row1.charAt(i), 1);
        }
        for (int i = 0; i < row2.length(); i++) {
            char2Row.put(row2.charAt(i), 2);
        }
        for (int i = 0; i < row3.length(); i++) {
            char2Row.put(row3.charAt(i), 3);
        }

        int idx = 0;
        String[] result = new String[words.length];

        outer:
        for (String word : words) {
            int row = char2Row.get(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                if (char2Row.get(word.charAt(i)) != row) {
                    continue outer;
                }
            }
            result[idx++] = word;
        }

        return Arrays.copyOf(result, idx);
    }
}
