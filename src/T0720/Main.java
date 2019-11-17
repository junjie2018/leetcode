package T0720;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Solution().longestWord(CommonUtils.createString1a(
                "[\"a\",\"ab\",\"acb\"]"
        ));
    }
}

class Solution {
    public String longestWord(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));

        if (words[0].length() != 1) return "";

        int idx = 0, pre = 1;
        List<String> candidateStrs = new ArrayList<>();
        while (idx < words.length) {
            String word = words[idx];

            if (word.length() == 1) {
                candidateStrs.add(word);
                ++idx;
                continue;
            }

            if (word.length() != pre + 1) {
                return candidateStrs.get(0);
            }

            List<String> tmpCandidateStrs = new ArrayList<>();
            while (idx < words.length && words[idx].length() == pre + 1) {
                String tmp = words[idx].substring(0, word.length() - 1);
                for (String candidateStr : candidateStrs) {
                    if (tmp.equals(candidateStr)) {
                        tmpCandidateStrs.add(words[idx]);
                        break;
                    }
                }
                idx++;
            }

            if (tmpCandidateStrs.size() == 0) {
                Collections.sort(candidateStrs);
                return candidateStrs.get(0);
            }

            pre = word.length();
            candidateStrs = tmpCandidateStrs;
        }

        Collections.sort(candidateStrs);
        return candidateStrs.get(0);
    }
}