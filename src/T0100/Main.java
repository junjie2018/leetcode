package T0100;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrder(p, q);
    }

    private boolean preOrder(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null | q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!preOrder(p.left, q.left)) return false;
        if (!preOrder(p.right, q.right)) return false;

        return true;
    }
}
