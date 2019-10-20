package T0301;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().removeInvalidParentheses("(a)())()"));
//        System.out.println(new Solution().removeInvalidParentheses(")(f"));
//        System.out.println(new Solution().removeInvalidParentheses("((i)"));
//        System.out.println(new Solution().removeInvalidParentheses(")()))())))"));
        System.out.println(new Solution().removeInvalidParentheses(")t))()()bo)"));

    }
}

/*
    用dfs做一下吧
 */
class Solution {

    private int len;
    private String input;
    private StringBuilder sb;
    private TreeSet<String> treeSet;


    public List<String> removeInvalidParentheses(String s) {
        this.len = s.length();
        this.input = s;
        this.treeSet = new TreeSet<>((a, b) -> a.length() == b.length() ? a.compareTo(b) : Integer.compare(b.length(), a.length()));
        this.sb = new StringBuilder();

        removeInvalidParenthesesCore(0, 0, 0);

        return new ArrayList<>(treeSet);
    }


    private void removeInvalidParenthesesCore(int idx, int leftCount, int changeCount) {
        // input.length() - treeSet.first().length() 为结果set中目前删除元素最少的结果
        if (treeSet.size() > 0 && changeCount > (input.length() - treeSet.first().length())) {
            return;
        }

        int sbStartPoint = sb.length();

        while (idx < len) {
            char aChar = input.charAt(idx);

            // 尽量维护原串，便于后面优化
            switch (aChar) {
                case '(':
                    sb.append('(');
                    removeInvalidParenthesesCore(idx + 1, leftCount + 1, changeCount);
                    sb.deleteCharAt(sb.length() - 1);
                    removeInvalidParenthesesCore(idx + 1, leftCount, changeCount + 1);
                    if (sbStartPoint < sb.length()) sb.delete(sbStartPoint, sb.length());
                    return;
                case ')':
                    if (leftCount - 1 >= 0) {
                        sb.append(')');
                        removeInvalidParenthesesCore(idx + 1, leftCount - 1, changeCount);
                        sb.deleteCharAt(sb.length() - 1);
                        removeInvalidParenthesesCore(idx + 1, leftCount, changeCount + 1);
                        if (sbStartPoint < sb.length()) sb.delete(sbStartPoint, sb.length());
                        return;
                    }
                    ++changeCount;
                    ++idx;
                    break;
                default:
                    sb.append(aChar);
                    ++idx;
                    break;
            }
        }

        if (leftCount == 0 && (treeSet.size() == 0 || changeCount <= (input.length() - treeSet.first().length()))) {
            treeSet.add(sb.toString());
        }

        if (sbStartPoint < sb.length()) sb.delete(sbStartPoint, sb.length());
    }
}
