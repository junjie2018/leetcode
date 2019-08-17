package T0107;

import Common.TreeNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) return new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        List<List<Integer>> result = new ArrayList<>();

        while (queue.size() > 0) {
            Deque<TreeNode> tmpQueue = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (queue.size() > 0) {
                TreeNode tmp = queue.removeFirst();
                list.add(tmp.val);

                if (tmp.left != null) tmpQueue.addLast(tmp.left);
                if (tmp.right != null) tmpQueue.addLast(tmp.right);
            }
            queue = tmpQueue;
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}
