package T0114;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                getLeftLastTreeNode(node.left).right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }


    private TreeNode getLeftLastTreeNode(TreeNode node) {
        preOrder(node);
        return result;
    }

    private TreeNode result;

    private void preOrder(TreeNode node) {
        if (node == null) return;

        this.result = node;

        preOrder(node.left);
        preOrder(node.right);
    }
}
