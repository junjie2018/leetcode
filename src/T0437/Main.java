package T0437;

import Common.CommonUtils;
import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().pathSum(
                CommonUtils.createTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]"),
                8
        ));
    }
}

class Solution {
    private int sum;
    private int res;

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        this.res = 0;

        pathSumCore(root, new ArrayList<>());

        return res;
    }

    private void pathSumCore(TreeNode node, List<Integer> list) {

        if (null == node) return;

        for (int i = 0; i < list.size(); i++) {
            int curSum = list.get(i) + node.val;
            if (curSum == sum) ++res;
            list.set(i, curSum);
        }

        if (node.val == sum) ++res;
        list.add(node.val);

        pathSumCore(node.left, new ArrayList<>(list));
        pathSumCore(node.right, list);
    }
}
