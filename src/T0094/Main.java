package T0094;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();

        outer:
        while (true) {
            stack.push(curNode);
            curNode = curNode.left;
            while (curNode == null) {
                if (stack.size() == 0) break outer;
                TreeNode out = stack.pop();
                result.add(out.val);
                curNode = out.right;
            }
        }

        return result;
    }
}