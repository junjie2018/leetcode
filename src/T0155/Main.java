package T0155;

import Common.CommonUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    private static final int SIZE = 1024;

    private int min = Integer.MAX_VALUE;
    private int head = 0;
    private int[] arr = new int[SIZE];


    public MinStack() {

    }

    public void push(int x) {
        if (head >= SIZE) return;
        min = Math.min(min, x);
        arr[head++] = x;
    }

    public void pop() {
        if (head == 0) return;

        /*
            修正一下最小值
         */
        --head;
        if (arr[head] == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < head; i++) {
                min = Math.min(min, arr[i]);
            }
        }
        /*
            这样写在leetcode上无法通过，但是本地运行不会有任何问题，我猜问题在于head的计算时机
            if (arr[--head] == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < head; i++) {
                min = Math.min(min, arr[i]);
            }
        }
         */
    }

    public int top() {
        if (head == 0) return -1;
        return arr[head - 1];
    }

    public int getMin() {
        if (head == 0) return -1;
        return min;
    }
}