package T0530;

import Common.CommonUtils;
import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getMinimumDifference(
                CommonUtils.createTreeNode("[236,104,701,null,227,null,911]")
        ));
    }
}

class Solution {
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        midleOrder(root);
        return min;
    }

    private int pre = -1;

    private void midleOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        midleOrder(node.left);

        if (-1 != pre) {
            min = Math.min(min, Math.abs(node.val - pre));
        }
        pre = node.val;

        midleOrder(node.right);
    }
}
