package T0700;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) return null;
        return val == root.val ? root
                : val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}