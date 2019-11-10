package T0637;

import Common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);
        res.add(root.val + 0.);

        int count = 1;
        while (queue.size() > 0) {

            TreeNode tmp = queue.removeLast();
            if (null != tmp.left) queue.addFirst(tmp.left);
            if (null != tmp.right) queue.addFirst(tmp.right);

            --count;
            if (count == 0) {
                if (queue.size() > 0) {
                    double sum = 0.;
                    for (TreeNode treeNode : queue) {
                        sum += treeNode.val;
                    }
                    res.add(sum / queue.size());
                }
                count = queue.size();
            }
        }

        return res;
    }
}
