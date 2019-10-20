package T0225;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

    }
}

class MyStack {

    Deque<Integer> queue = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.addFirst(x);
    }

    public int pop() {
        int count = queue.size() - 1;
        while (count > 0) {
            queue.addFirst(queue.removeLast());
            --count;
        }
        return queue.removeLast();
    }

    public int top() {
        return queue.getFirst();
    }


    public boolean empty() {
        return queue.size() == 0;
    }
}
