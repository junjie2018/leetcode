package T0707;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));
    }
}

class MyLinkedList {

    private static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public MyLinkedList() {
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index >= size || index < 0) return -1;

        // 这个地方可以优化，但是不想动
        Node tmp = head.next;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }
        return tmp.value;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);

        // 调整右边
        node.next = head.next;
        head.next.prev = node;

        // 调整左边
        head.next = node;
        node.prev = head;

        ++size;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);

        // 调整左边
        node.prev = tail.prev;
        tail.prev.next = node;

        // 调整右边
        node.next = tail;
        tail.prev = node;

        ++size;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;

        if (index < 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        Node tmp = head.next;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }

        // 调整左边
        Node node = new Node(val);
        node.prev = tmp.prev;
        tmp.prev.next = node;

        // 调整右边
        node.next = tmp;
        tmp.prev = node;

        ++size;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;

        Node tmp = head.next;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }

        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;

        --size;
    }
}