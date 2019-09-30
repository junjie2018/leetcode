package T1080;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(1);
//        root.right = new TreeNode(8);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(-5);

        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(4);


        TreeNode treeNode = new Solution2().sufficientSubset(root, -1);
        System.out.println("tmp");

    }
}

/**
 * 我好像把这道题给理解错了
 * <p>
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
 */
class Solution {

    private int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;

        return sufficientSubsetCore(root, 0) ? null : root;
    }

    /**
     * 返回值表示该结点是否需要删除
     */
    private boolean sufficientSubsetCore(TreeNode node, int sum) {
        if (node.left != null) {
            if (sufficientSubsetCore(node.left, sum + node.val)) node.left = null;
        }
        if (node.right != null) {
            if (sufficientSubsetCore(node.right, sum + node.val)) node.right = null;
        }
        return node.left == null && node.right == null && sum + node.val < limit;
    }
}

class Solution2 {
    private int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;

        return dfs(root, 0);
    }

    private TreeNode dfs(TreeNode node, int sum) {
        if (node == null) return null;

        if (node.left == null && node.right == null) {
            if (sum + node.val < limit) return null;
            return node;
        }

        node.left = dfs(node.left, sum + node.val);
        node.right = dfs(node.right, sum + node.val);

        if (node.left == null && node.right == null) return null;
        return node;
    }
}

class Solution3 {
    private int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;

        return sufficientSubsetCore(root, 0);
    }

    private TreeNode sufficientSubsetCore(TreeNode node, int sum) {
        if (node == null) return null;

        // node 原本就是叶子节点
        if (node.left == null && node.right == null) {
            return sum + node.val < limit ? null : node;
        }

        node.left = sufficientSubsetCore(node.left, sum + node.val);
        node.right = sufficientSubsetCore(node.right, sum + node.val);

        // 不足结点
        return (node.left == null && node.right == null) ? null : node;
    }
}
