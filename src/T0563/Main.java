package T0563;

import Common.CommonUtils;
import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findTilt(
                CommonUtils.createTreeNode("[1,2,3,4,null,5]")
        ));
    }
}

class Solution {
    public int findTilt(TreeNode root) {
        if (null == root) return 0;
        findTiltCore(root);
        return sum;
    }

    private int sum = 0;

    public int findTiltCore(TreeNode node) {
        if (null == node) return 0;
        int left = findTiltCore(node.left), right = findTiltCore(node.right);
        sum += Math.abs(left - right);
        return left + right + node.val;
    }
}
