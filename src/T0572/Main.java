package T0572;

import Common.CommonUtils;
import Common.TreeNode;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isSubtree(
                CommonUtils.createTreeNode("[1,1]"),
                CommonUtils.createTreeNode("[1]")
//                CommonUtils.createTreeNode("[3,4,5,1,null,2]"),
//                CommonUtils.createTreeNode("[3,1,2]")
//                CommonUtils.createTreeNode("[3,4,5,1,2,null,null,null,null,0]"),
//                CommonUtils.createTreeNode("[4,1,2]")
        ));
    }
}

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        this.target = postOrder(t, null);
        postOrder(s, c -> {
            if (target.equals(c)) {
                res = true;
            }
        });
        return res;
    }

    private String target;
    private boolean res;

    private String postOrder(TreeNode node, Consumer<String> callback) {
        if (null == node) return "";
        String l = postOrder(node.left, callback);
        String r = postOrder(node.right, callback);
        String c = l + r + node.val;
        if (callback != null) {
            callback.accept(c);
        }
        return c;
    }
}
