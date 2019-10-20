package T0232;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

    }
}

class MyQueue {

    Deque<Integer> toAddFirst = new ArrayDeque<>();
    Deque<Integer> toRemoveLast = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (toRemoveLast.size() > 0) {
            toAddFirst.push(toRemoveLast.pop());
        }
        toAddFirst.push(x);
    }

    public int pop() {
        while (toAddFirst.size() > 0) {
            toRemoveLast.push(toAddFirst.pop());
        }
        return toRemoveLast.pop();
    }

    public int peek() {
//        while (toRemoveLast.size() > 0) {
//            toAddFirst.push(toRemoveLast.pop());
//        }
//        return toAddFirst.peek();
        while (toAddFirst.size() > 0) {
            toRemoveLast.push(toAddFirst.pop());
        }
        return toRemoveLast.peek();
    }

    public boolean empty() {
        return toAddFirst.size() == 0 && toRemoveLast.size() == 0;
    }
}