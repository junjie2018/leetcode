package T0429;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (null == root) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        Deque<Node> queue = new ArrayDeque<>();
        queue.addFirst(root);
        int count = queue.size();
        ArrayList<Integer> list = new ArrayList<>();
        while (queue.size() > 0) {

            Node node = queue.removeLast();
            list.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    queue.addFirst(child);
                }
            }

            --count;
            if (count == 0) {
                count = queue.size();
                result.add(list);
                list = new ArrayList<>();
            }
        }

        return result;
    }
}