package T1110;

import Common.TreeNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 使用层序遍历的方式
 */
class Solution {

    private int[] to_delete;
    private List<TreeNode> result;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Arrays.sort(to_delete);
        this.to_delete = to_delete;
        this.result = new LinkedList<>();

        postOrderForMark(root);
        postOrderForDelete(null, true, root);

        return result;
    }

    private void postOrderForMark(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        postOrderForMark(treeNode.left);
        postOrderForMark(treeNode.right);
        if (needDelete(treeNode)) {
            treeNode.val = -treeNode.val;
        }
    }

    private void postOrderForDelete(TreeNode parent, boolean isLeft, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderForDelete(treeNode, true, treeNode.left);
        postOrderForDelete(treeNode, false, treeNode.right);

        if (parent != null && parent.val > 0 && treeNode.val < 0) {
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        if ((parent == null || parent.val < 0) && treeNode.val > 0) {
            result.add(treeNode);
        }
    }

    private boolean needDelete(TreeNode target) {
        return Arrays.binarySearch(to_delete, 0, to_delete.length, target.val) >= 0;
    }
}
