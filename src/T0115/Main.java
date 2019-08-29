package T0115;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution2().numDistinct("rabbbit", "rabbit"));
        System.out.println(new Solution().numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe", "bddabdcae"));
    }
}

/**
 * 超出时间限制了
 */
class Solution {
    public int numDistinct(String s, String t) {


        TreeNode root = new TreeNode(0);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);

        for (int i = 0; i < s.length(); i++) {
            Deque<TreeNode> tmp = new ArrayDeque<>();

            while (queue.size() > 0) {
                TreeNode node = queue.removeLast();

                // 如果当前node已匹配到t字符串末尾，则不进行处理
                if (node.val == t.length()) continue;

                // 如果当前node与当前处理的字符不匹配，则将当前node放入栈中
                if (t.charAt(node.val) != s.charAt(i)) {
                    tmp.addFirst(node);
                    continue;
                }

                // 如果当前node与当前处理的字符匹配，则生成当前结点的左右子树
                node.left = new TreeNode(node.val);
                node.right = new TreeNode(node.val + 1);

                tmp.addFirst(node.left);
                tmp.addFirst(node.right);
            }
            queue = tmp;
        }

        preOrder(root, t.length());

        return count;
    }

    private int count = 0;

    private void preOrder(TreeNode node, int target) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            if (node.val == target) count++;
            return;
        }

        preOrder(node.left, target);
        preOrder(node.right, target);
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}

/**
 * 使用一种新的方案
 */
class Solution2 {
    public int numDistinct(String s, String t) {

        int[] lengthToCount = new int[t.length() + 1];
        lengthToCount[0] = 1;

        Map<Character, List<Integer>> charToLength = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!charToLength.containsKey(t.charAt(i))) {
                charToLength.put(t.charAt(i), new ArrayList<>());
            }
            charToLength.get(t.charAt(i)).add(i + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charToLength.containsKey(s.charAt(i))) {
                List<Integer> tmp = charToLength.get(s.charAt(i));
                for (int j = tmp.size() - 1; j >= 0; j--) {
                    int length = tmp.get(j);
                    lengthToCount[length] += lengthToCount[length - 1];
                }
            }
        }

        return lengthToCount[t.length()];
    }
}
