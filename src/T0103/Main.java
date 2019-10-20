package T0103;

import Common.TreeNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

// bsf
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);

        int layer = 1, count = queue.size();
        List<Integer> list = new ArrayList<>();
        while (queue.size() > 0) {
            if (layer % 2 == 1) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                list.add(node.val);
            } else {
                TreeNode node = queue.removeLast();
                if (node.right != null) queue.addFirst(node.right);
                if (node.left != null) queue.addFirst(node.left);
                list.add(node.val);
            }

            if (--count == 0) {
                layer++;
                count = queue.size();
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }
}