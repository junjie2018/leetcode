package T0235;

import Common.CommonUtils;
import Common.TreeNode;

public class Main {
    public static void main(String[] args) {
        new Solution().lowestCommonAncestor(
                CommonUtils.createTreeNode("[6,2,8,0,4,7,9,null,null,3,5]"),
                new TreeNode(3),
                new TreeNode(5)
        );
    }
}

@SuppressWarnings("all")
class Solution {
    private TreeNode p, q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        return lowestCommonAncestorCore(root, new Tuple());
    }

    private TreeNode lowestCommonAncestorCore(TreeNode node, Tuple tuple) {
        if (node == null) return null;

        Tuple curTuple = new Tuple();
        if (node.val == p.val) curTuple.hasFindP = true;
        if (node.val == q.val) curTuple.hasFindQ = true;

        if ((tuple.hasFindP && curTuple.hasFindQ) || (tuple.hasFindQ && curTuple.hasFindP)) {
            tuple.hasFindP = true;
            tuple.hasFindQ = true;
            return null;
        }


        TreeNode res = null;

        res = lowestCommonAncestorCore(node.left, curTuple);
        if (null != res) return res;
        if (curTuple.hasFindP && curTuple.hasFindQ) return node;

        res = lowestCommonAncestorCore(node.right, curTuple);
        if (null != res) return res;
        if (curTuple.hasFindP && curTuple.hasFindQ) return node;

        tuple.hasFindP = tuple.hasFindP ? true : curTuple.hasFindP;
        tuple.hasFindQ = tuple.hasFindQ ? true : curTuple.hasFindQ;

        return null;
    }

    private static class Tuple {
        boolean hasFindP;
        boolean hasFindQ;
    }
}
