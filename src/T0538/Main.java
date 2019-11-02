package T0538;

import Common.CommonUtils;
import Common.TreeNode;
import sun.reflect.generics.tree.Tree;

public class Main {
    public static void main(String[] args) {
        new Solution().convertBST(
                CommonUtils.createTreeNode("[1,0,4,-2,null,3]")
        );
    }
}

class Solution {
    public TreeNode convertBST(TreeNode root) {
        convertBSTCore(root, 0);
        return root;
    }

    private TreeNode convertBSTCore(TreeNode node, int sumFormParent) {
        if (null == node) return null;

        if (null == node.right) {
            node.val += sumFormParent;
        } else {
            node.val += convertBSTCore(node.right, sumFormParent).val;
        }

        TreeNode res = convertBSTCore(node.left, node.val);
        return null == res ? node : res;
    }
}
