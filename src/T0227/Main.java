package T0227;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().calculate("0/1"));
        System.out.println(new Solution().calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}

// 这道题我会很多解法，但是都不太熟练，我决定用栈的方式来解吧
@SuppressWarnings("all")
class Solution {
    public int calculate(String s) {
        Deque<String> tmp = new ArrayDeque<>();
        Deque<String> out = new ArrayDeque<>();

        s = s.replace(" ", "");

        int idx = 0;
        while (idx < s.length()) {
            char aChar = s.charAt(idx);

            if (aChar == '*' || aChar == '/') {
                while (tmp.size() > 0 && ("*".equals(tmp.peek()) || "/".equals(tmp.peek()))) {
                    out.push(tmp.pop());
                }
                tmp.push(String.valueOf(aChar));
                idx++;
                continue;
            }

            if (aChar == '+' || aChar == '-') {
                while (tmp.size() > 0) {
                    out.push(tmp.pop());
                }
                tmp.push(String.valueOf(aChar));
                idx++;
                continue;
            }

            // 处理操作数
            int startIdx = idx;
            while (idx + 1 < s.length() && s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '9') {
                idx++;
            }
            out.push(s.substring(startIdx, idx + 1));
            idx++;
        }

        while (tmp.size() > 0) {
            out.push(tmp.pop());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        while (out.size() > 0) {
            String str = out.removeLast();
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch (str) {
                    case "+":
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        stack.push(op1 - op2);
                        break;
                    case "*":
                        stack.push(op1 * op2);
                        break;
                    case "/":
                        stack.push(op1 / op2);
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }

        return stack.pop();
    }
}

