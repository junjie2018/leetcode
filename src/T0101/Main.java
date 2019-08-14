package T0101;

import Common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 使用迭代的方法解题
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (true) {
            for (int i = 0; i < queue.size() / 2; i++) {
                TreeNode left = queue.get(i), right = queue.get(queue.size() - 1 - i);

                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (queue.get(i).val != queue.get(queue.size() - 1 - i).val) {
                    return false;
                }
            }
            LinkedList<TreeNode> tmpQueue = new LinkedList<>();
            while (queue.size() > 0) {
                TreeNode tmp = queue.removeLast();
                if (tmp != null) {
                    tmpQueue.addFirst(tmp.right);
                    tmpQueue.addFirst(tmp.left);
                }
            }
            if (tmpQueue.size() == 0) {
                return true;
            }
            queue = tmpQueue;
        }
    }
}

class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricCore(root.left, root.right);
    }

    private boolean isSymmetricCore(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        if (!isSymmetricCore(left.left, right.right)) return false;
        if (!isSymmetricCore(left.right, right.left)) return false;

        return true;
    }
}
