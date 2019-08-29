package T0113;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    private int sum;
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();

        this.sum = sum;
        this.result = new ArrayList<>();

        pathSumCore(root, new ArrayList<>(), 0);

        return result;
    }

    private void pathSumCore(TreeNode node, List<Integer> list, int curSum) {

        curSum += node.val;
        list.add(node.val);

        if (node.left == null && node.right == null) {
            if (curSum == sum) result.add(list);
            return;
        }

        if (node.left != null && node.right != null) {
            pathSumCore(node.left, new ArrayList<>(list), curSum);
            pathSumCore(node.right, list, curSum);
            return;
        }

        if (node.left != null) pathSumCore(node.left, list, curSum);
        if (node.right != null) pathSumCore(node.right, list, curSum);
    }
}
