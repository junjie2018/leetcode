package T1111;

import Common.CommonUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().maxDepthAfterSplit("()(())()"));
    }
}

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] depths = new int[seq.length()];

        int depth = 0;
        int maxDepth = Integer.MIN_VALUE;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == ')') {
                stack.pop();
                depths[i] = depth--;
                continue;
            }
            stack.push('(');
            depths[i] = ++depth;
            if (depth > maxDepth) maxDepth = depth;
        }

        int targetDepth = maxDepth / 2;

        for (int i = 0; i < depths.length; i++) {
            depths[i] = depths[i] <= targetDepth ? 1 : 0;
        }

        return depths;
    }
}
