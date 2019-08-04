package T0316;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
//        System.out.println(new Solution().removeDuplicateLetters("abacb"));
        System.out.println(new Solution().removeDuplicateLetters("bbcaac"));
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int[] counts = new int[256];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }

        int[] flag = new int[256];
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        counts[s.charAt(0)]--;
        flag[s.charAt(0)]++;
        for (int i = 1; i < s.length(); i++) {
            char aChar = s.charAt(i);
            char bChar = sb.charAt(sb.length() - 1);

            // 决定当前元素是否需要抛弃
            if (flag[aChar] > 0) {
                counts[aChar]--;
                continue;
            }

            // 决定前面的元素是否需要抛弃
            while (aChar < bChar && counts[bChar] > 0) {
                sb.deleteCharAt(sb.length() - 1);
                flag[bChar]--;
                if (sb.length() > 0) {
                    bChar = sb.charAt(sb.length() - 1);
                } else {
                    break;
                }
            }

            sb.append(aChar);
            flag[aChar]++;

            counts[aChar]--;
        }

        return sb.toString();
    }
}