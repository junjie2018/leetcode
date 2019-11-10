package T0682;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        new Solution().calPoints(new String[]{
                "1",
                "2",
                "3",
                "+",
        });
    }
}

class Solution {
    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        int sum = 0, cur = 0;
        for (String op : ops) {
            switch (op) {
                case "+":
                    cur = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);
                    sum += cur;
                    stack.push(cur);
                    break;
                case "D":
                    cur = stack.peek() * 2;
                    sum += cur;
                    stack.push(cur);
                    break;
                case "C":
                    cur = stack.pop();
                    sum -= cur;
                    break;
                default:
                    cur = Integer.parseInt(op);
                    sum += cur;
                    stack.push(cur);
                    break;
            }
        }

        return sum;
    }
}
