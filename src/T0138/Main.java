package T0138;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Map<Integer, Node> id2Node = new HashMap<>();

        Node tmp = head;

        while (tmp != null) {
            Node node = new Node();
            id2Node.put(tmp.val, node);
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp != null) {
            Node node = id2Node.get(tmp.val);
            node.val = tmp.val;
            node.next = tmp.next == null ? null : id2Node.get(tmp.next.val);
            node.random = tmp.random == null ? null : id2Node.get(tmp.random.val);
            tmp = tmp.next;
        }

        return id2Node.get(head.val);
    }
}


