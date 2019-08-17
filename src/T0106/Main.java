package T0106;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeCore(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] postOrder, int postStart, int postEnd,
                                   int[] inOrder, int inStart, int inEnd) {

        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postOrder[postEnd]);

        int idx = getIdx(inOrder, inStart, inEnd, postOrder[postEnd]);
        int len = inEnd - idx;

        // 构建左子树
        node.left = buildTreeCore(postOrder, postStart, postEnd - len - 1,
                inOrder, inStart, idx - 1);

        // 构建右子树
        node.right = buildTreeCore(postOrder, postEnd - len, postEnd - 1,
                inOrder, idx + 1, inEnd);

        return node;
    }

    private int getIdx(int[] array, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}