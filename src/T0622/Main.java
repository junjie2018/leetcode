package T0622;

public class Main {
    public static void main(String[] args) {

    }
}

/*
    给的测试案例要求不能有空位做表示，头疼
 */
class MyCircularQueue {

    private int[] arr;
    private int size;
    private int head, tail;

    public MyCircularQueue(int k) {
        arr = new int[k];
        size = k;
        head = 0;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if ((head + 1 % size) % size == tail) {
            return false;
        }
        arr[head++] = value; // 有小问题
        return true;
    }

    public boolean deQueue() {
        if (head == tail) {
            return false;
        }
        tail++; // 有小问题
        return true;
    }

    public int Front() {
        if (head == tail) {
            return -1;
        }
        return arr[head];
    }

    public int Rear() {
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

/*
    没有记录leetcode上的代码，感觉它很奇怪
 */
class MyCircularQueue2 {

    private int[] arr;
    private int size;
    private int head, tail;
    boolean isEmpty, isFull;

    public MyCircularQueue2(int k) {
        arr = new int[k];
        size = k;
        head = 0;
        tail = 0;
        isEmpty = true;
        isFull = false;
    }

    public boolean enQueue(int value) {
        if (isFull) {
            return false;
        }
        arr[head] = value;
        head = (head + 1) % size;
        if (head == tail) {
            isFull = true;
        }
        isEmpty = false;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty) {
            return false;
        }
        tail = (tail + 1) % size;
        if (head == tail) {
            isEmpty = true;
        }
        isFull = false;
        return true;
    }

    public int Front() {
        if (isEmpty) {
            return -1;
        }
        return arr[head - 1];
    }

    public int Rear() {
        if (isEmpty) {
            return -1;
        }
        return arr[tail];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isFull() {
        return isFull;
    }
}