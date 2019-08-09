package T0146;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        /*
            ["LRUCache","put","put","get","put","get","put","get","get","get"]
            [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
         */
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

class LRUCache {

    private int capacity;
    private List list = new List();
    private HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            list.remove(tmp);
            list.addFirst(tmp);
            return tmp.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            list.remove(tmp);
            list.addFirst(tmp);
            tmp.value = value;
        } else {
            if (map.size() >= capacity) {
                map.remove(list.removeLast().key);
            }
            Node node = new Node(key, value);
            list.addFirst(node);
            map.put(key, node);
        }
    }

    static class Node {
        int key;
        int value;

        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class List {
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);

        {
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(Node node) {

            node.next = head.next;
            node.pre = head;

            head.next.pre = node;
            head.next = node;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
        }

        public Node removeLast() {
            Node tmp = tail.pre;
            tmp.pre.next = tail;
            tmp.next.pre = tmp.pre;
            return tmp;
        }
    }
}
