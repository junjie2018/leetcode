package T0224;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}

@SuppressWarnings("all")
class Solution {
    public int calculate(String s) {

        s = s.replace(" ", "");

        Deque<String> optStack = new ArrayDeque<>();
        Deque<String> outStack = new ArrayDeque<>();

        int idx = 0;
        while (idx < s.length()) {
            char aChar = s.charAt(idx);

            if (aChar == '(') {
                optStack.push(String.valueOf(aChar));
                idx++;
                continue;
            }

            if (aChar == '+' || aChar == '-') {
                while (optStack.size() > 0 && !"(".equals(optStack.peek())) {
                    outStack.push(optStack.pop());
                }
                optStack.push(String.valueOf(aChar));
                idx++;
                continue;
            }

            if (aChar == ')') {
                while (!"(".equals(optStack.peek())) {
                    outStack.push(optStack.pop());
                }
                optStack.pop();
                idx++;
                continue;
            }

            // 处理操作数
            int startIdx = idx;
            while (idx + 1 < s.length() && s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '9') {
                idx++;
            }
            outStack.push(s.substring(startIdx, idx + 1));
            idx++;
        }

        while (optStack.size() > 0) {
            outStack.push(optStack.pop());
        }

        Deque<Integer> resStack = new ArrayDeque<>();
        while (outStack.size() > 0) {
            String str = outStack.removeLast();
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                int op2 = resStack.pop();
                int op1 = resStack.pop();
                switch (str) {
                    case "+":
                        resStack.push(op1 + op2);
                        break;
                    case "-":
                        resStack.push(op1 - op2);
                        break;
                }
            } else {
                resStack.push(Integer.valueOf(str));
            }
        }
        return resStack.pop();
    }
}