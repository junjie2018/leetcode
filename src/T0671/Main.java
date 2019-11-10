package T0671;

import Common.CommonUtils;
import Common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        new Solution().findSecondMinimumValue(
                CommonUtils.createTreeNode("[2,2,2147483647]")
        );
    }
}

class Solution {
    private boolean hasResult;
    private int min, secMin;

    public int findSecondMinimumValue(TreeNode root) {
        this.min = root.val;
        this.secMin = Integer.MAX_VALUE;

        preOrder(root);

        return hasResult ? secMin : -1;
    }

    private void preOrder(TreeNode node) {
        if (null == node) return;

        if (node.val != min && node.val <= secMin) {
            hasResult = true;
            secMin = node.val;
        }

        preOrder(node.left);
        preOrder(node.right);
    }
}

