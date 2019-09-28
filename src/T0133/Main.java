package T0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        new Solution().cloneGraph(n1);

        System.out.println("你好");
    }
}

class Node {
    int val;
    List<Node> neighbors;

    Node() {
    }

    Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution {

    private Map<Integer, Node> val2Node = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (val2Node.containsKey(node.val)) {
            return val2Node.get(node.val);
        }

        Node tmp = new Node();
        val2Node.put(node.val, tmp);

        List<Node> neighbors = new ArrayList<>();
        node.neighbors.forEach(item -> {
            neighbors.add(cloneGraph(item));
        });

        tmp.val = node.val;
        tmp.neighbors = neighbors;

        return tmp;
    }
}

