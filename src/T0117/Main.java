package T0117;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            Deque<Node> tmp = new ArrayDeque<>();
            while (queue.size() > 0) {
                Node node = queue.removeFirst();
                node.next = queue.size() > 0 ? queue.getFirst() : null;
                if (node.left != null) tmp.addLast(node.left);
                if (node.right != null) tmp.addLast(node.right);
            }
            queue = tmp;
        }
        return root;
    }
}