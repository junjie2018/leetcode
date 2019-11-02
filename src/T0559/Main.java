package T0559;

import java.util.ArrayDeque;
import java.util.Deque;
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
    public int maxDepth(Node root) {

        if (null == root) return 0;

        Deque<Node> queue = new ArrayDeque<>();
        queue.addFirst(root);

        int depth = 0;
        int count = 1;
        while (queue.size() > 0) {
            Node tmp = queue.removeLast();
            for (Node child : tmp.children) {
                queue.addFirst(child);
            }

            --count;
            if (count == 0) {
                ++depth;
                count = queue.size();
            }
        }

        return depth;
    }
}