package T0641;

public class Main {
    public static void main(String[] args) {
        MyCircularDeque queue = new MyCircularDeque(3);
        queue.insertLast(1);
        queue.insertLast(2);
        queue.insertFront(3);
        queue.insertFront(4);
        queue.getRear();
        queue.isFull();
        queue.deleteLast();
        queue.insertFront(4);
        queue.getFront();
    }
}

class MyCircularDeque {

    private int size;
    private int[] arr;
    private int head, tail;

    public MyCircularDeque(int k) {
        size = k + 1;
        arr = new int[size];
        head = 0;
        tail = 0;
    }

    public boolean insertFront(int value) {
        if ((head + 1) % size == tail) {
            return false;
        }
        arr[head] = value;
        head = (++head) % size;
        return true;
    }

    public boolean insertLast(int value) {
        if ((head + 1) % size == tail) {
            return false;
        }

        tail = (tail + size - 1) % size;
        arr[tail] = value;
        return true;
    }

    public boolean deleteFront() {
        if (head == tail) {
            return false;
        }
        head = (head + size - 1) % size;
        return true;
    }

    public boolean deleteLast() {
        if (head == tail) {
            return false;
        }
        tail = (++tail) % size;
        return true;
    }

    public int getFront() {
        if (head == tail) {
            return -1;
        }
        return arr[(head - 1 + size) % size];
    }

    public int getRear() {
        if (head == tail) {
            return -1;
        }
        return arr[tail];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (head + 1) % size == tail;
    }
}