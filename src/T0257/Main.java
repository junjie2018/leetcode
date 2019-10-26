package T0257;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    private List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();

        this.result = new ArrayList<>();

        binaryTreePathsCore(root, new StringBuilder());

        return result;
    }

    private void binaryTreePathsCore(TreeNode node, StringBuilder sb) {

        if (sb.length() == 0) {
            sb.append(node.val);
        } else {
            sb.append("->").append(node.val);
        }

        if (null == node.left && null == node.right) {
            result.add(sb.toString());
        }

        if (null != node.left && null != node.right) {
            StringBuilder tmp = new StringBuilder(sb);
            binaryTreePathsCore(node.left, tmp);
            binaryTreePathsCore(node.right, sb);
            return;
        }

        if (null != node.left) {
            binaryTreePathsCore(node.left, sb);
        }

        if (null != node.right) {
            binaryTreePathsCore(node.right, sb);
        }
    }
}
