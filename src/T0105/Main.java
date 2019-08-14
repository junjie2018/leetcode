package T0105;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        new Solution().buildTree(new int[]{
                3, 9, 20, 15, 7
        }, new int[]{
                9, 3, 15, 20, 7
        });
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeCore(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] preOrder, int preStart, int preEnd,
                                   int[] inOrder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder[preStart]);

        int idx = getIdx(inOrder, inStart, inEnd, preOrder[preStart]);
        int len = idx - inStart;

        node.left = buildTreeCore(preOrder, preStart + 1, preStart + len,
                inOrder, inStart, idx - 1);
        node.right = buildTreeCore(preOrder, preStart + len + 1, preEnd,
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