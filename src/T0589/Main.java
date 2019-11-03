package T0589;

import java.util.ArrayList;
import java.util.List;

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

    private List<Integer> result;

    public List<Integer> preorder(Node root) {
        this.result = new ArrayList<>();
        preOrderCore(root);
        return result;
    }

    private void preOrderCore(Node node) {
        if (null == node) return;
        result.add(node.val);
        for (Node child : node.children) {
            preOrderCore(child);
        }
    }
}
