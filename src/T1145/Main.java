package T1145;

import Common.CommonUtils;
import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        new Solution().btreeGameWinningMove(
//                CommonUtils.createTreeNode("[1,2,3,4,5,6,7,8,9,10,11]"),
//                11,
//                3
                CommonUtils.createTreeNode("[1,2,3,4,5,6,7]"),
                7,
                1
        );
    }
}

class Solution {

    private TreeNode xNode;
    private int parentLen = 0;
    private int leftLen = 0;
    private int rightLen = 0;

    private int x;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;

        getParentLen(root);
        getLeftLen(xNode.left);
        getRightLen(xNode.right);

        if (parentLen > leftLen + rightLen) return true;
        if (leftLen > parentLen + rightLen) return true;
        if (rightLen > parentLen + leftLen) return true;
        return false;
    }

    private void getParentLen(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xNode = node;
            return;
        }

        parentLen++;

        getParentLen(node.left);
        getParentLen(node.right);
    }

    private void getLeftLen(TreeNode node) {
        if (node == null) return;

        leftLen++;

        getLeftLen(node.left);
        getLeftLen(node.right);
    }

    private void getRightLen(TreeNode node) {
        if (node == null) return;

        rightLen++;

        getRightLen(node.left);
        getRightLen(node.right);
    }
}
