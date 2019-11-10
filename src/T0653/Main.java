package T0653;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        midOrder(root);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum > k) {
                --right;
            } else if (sum < k) {
                ++left;
            } else {
                return true;
            }
        }
        return false;
    }

    private void midOrder(TreeNode node) {
        if (null == node) return;
        midOrder(node.left);
        list.add(node.val);
        midOrder(node.right);
    }
}
