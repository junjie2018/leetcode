package T0095;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Solution().generateTrees(3);
    }
}

/*
    这道题没有用到深复制，可能不是最完美的解
 */
class Solution {

    private List<TreeNode>[][] dp;

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) return Collections.emptyList();

        this.dp = new List[n + 1][n + 1];
        generateTreesCore(1, n);
        return dp[1][n];
    }

    private List<TreeNode> generateTreesCore(int left, int right) {
        int length = right - left + 1;
        if (length == 0) return Collections.emptyList();
        if (dp[left][right] != null) return dp[left][right];

        List<TreeNode> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = generateTreesCore(left, i - 1);
            List<TreeNode> rightList = generateTreesCore(i + 1, right);
            if (leftList.size() == 0 && rightList.size() == 0) {
                result.add(new TreeNode(i));
            } else if (leftList.size() > 0 && rightList.size() > 0) {
                for (TreeNode leftNode : leftList) {
                    for (TreeNode rightNode : rightList) {
                        TreeNode node = new TreeNode(i);
//                        node.left = new TreeNode(leftNode.val);
//                        node.right = new TreeNode(rightNode.val);
                        node.left = leftNode;
                        node.right = rightNode;
                        result.add(node);
                    }
                }
            } else {
                if (leftList.size() != 0) {
                    for (TreeNode leftNode : leftList) {
                        TreeNode node = new TreeNode(i);
//                        node.left = new TreeNode(leftNode.val);
                        node.left = leftNode;
                        result.add(node);
                    }
                } else {
                    for (TreeNode rightNode : rightList) {
                        TreeNode node = new TreeNode(i);
//                        node.right = new TreeNode(rightNode.val);
                        node.right = rightNode;
                        result.add(node);
                    }
                }
            }
        }
        dp[left][right] = result;
        return result;
    }
}
