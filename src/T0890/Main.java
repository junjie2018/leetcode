package T0890;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findAndReplacePattern(
                CommonUtils.createString1a("[\"abc\",\"deq\",\"mee\",\"aqq\",\"dkd\",\"ccc\"]"),
//                CommonUtils.createString1a("[\"ccc\"]"),
                "abb"
        ));
    }
}

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        int len = pattern.length();

        List<String> result = new ArrayList<>();

        outer:
        for (String word : words) {
            int[] w2p = new int[26];
            int[] p2w = new int[26];

            for (int i = 0; i < len; i++) {
                int w = word.charAt(i) - 'a';
                int p = pattern.charAt(i) - 'a';

                // w2p方向
                if (w2p[w] != 0) {
                    if (w2p[w] - 1 != p) continue outer;
                } else {
                    w2p[w] = p + 1;
                }

                // p2w方向
                if (p2w[p] != 0) {
                    if (p2w[p] - 1 != w) continue outer;
                } else {
                    p2w[p] = w + 1;
                }
            }
            result.add(word);
        }

        return result;
    }
}