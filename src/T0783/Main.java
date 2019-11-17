package T0783;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minDiffInBST(TreeNode root) {
        midOrder(root);
        return min;
    }

    private boolean isSetPre = false;
    private int pre = 0;
    private int min = Integer.MAX_VALUE;

    private void midOrder(TreeNode node) {
        if (null == node) {
            return;
        }

        midOrder(node.left);

        if (isSetPre) {
            if (node.val - pre < min) min = node.val - pre;
        } else {
            isSetPre = true;
        }
        pre = node.val;


        midOrder(node.right);
    }
}