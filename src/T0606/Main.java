package T0606;

import Common.TreeNode;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String tree2str(TreeNode t) {
        preOrder(t);
        return sb.toString();
    }

    private StringBuilder sb = new StringBuilder();

    private void preOrder(TreeNode node) {
        if (null == node) return;

        sb.append(node.val);


        if (null != node.left || null != node.right) {
            sb.append("(");
            preOrder(node.left);
            sb.append(")");
        }

        if (null != node.right) {
            sb.append("(");
            preOrder(node.right);
            sb.append(")");
        }
    }
}
