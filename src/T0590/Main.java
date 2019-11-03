package T0590;

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

    public List<Integer> postorder(Node root) {
        this.result = new ArrayList<>();
        postOrderCore(root);
        return result;
    }

    private void postOrderCore(Node node) {
        if (null == node) return;
        for (Node child : node.children) {
            postOrderCore(child);
        }
        result.add(node.val);
    }
}
