package T0669;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (null == root) return null;

        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
