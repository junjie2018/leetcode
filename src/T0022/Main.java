package T0022;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        new Solution3().generateParenthesis(3);
        System.out.println(new Solution3().generateParenthesis(3).toString());
    }
}

class Solution {
    private List<String> result = new ArrayList<>(1024);

    private StringBuilder sb;
    private Stack stack;
    private int length;

    public List<String> generateParenthesis(int n) {
        this.length = 2 * n;
        this.stack = new Stack(n);
        this.sb = new StringBuilder();

        generateParenthesisCore(0);

        return result;
    }

    private void generateParenthesisCore(int n) {
        if (n >= length) {
            if (stack.isEmpty()) {
                result.add(sb.toString());
            }
            return;
        }

        // 处理 '('
        if (!stack.isFull()) {
            stack.push('(');
            sb.append('(');
            generateParenthesisCore(n + 1);
            sb.deleteCharAt(sb.length() - 1);
            stack.pop();
        }

        // 处理 ')'
        if (!stack.isEmpty() && stack.pop() == '(') {
            sb.append(')');
            generateParenthesisCore(n + 1);
            sb.deleteCharAt(sb.length() - 1);
            stack.push('(');
        }
    }

    static class Stack {
        char[] chars = null;
        int i = 0; //指向当前空位
        int size;

        Stack(int size) {
            this.size = size;
            chars = new char[size];
        }

        void push(char c) {
            chars[i++] = c;
        }

        char pop() {
            if (i == 0) {
                return 0;
            }
            return chars[--i];
        }

        public boolean isEmpty() {
            return i == 0;
        }

        public boolean isFull() {
            return i >= size;
        }
    }
}

class Solution1 {
    List<String> result = new ArrayList<>(1024);
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    private int length = 0;

    public List<String> generateParenthesis(int n) {
        this.length = 2 * n;

        generateParenthesisCore(0);

        return result;
    }

    private void generateParenthesisCore(int n) {
        if (n >= length) {
            if (stack.isEmpty()) {
                result.add(sb.toString());
            }
            return;
        }

        // 处理 '('
        stack.push('(');
        sb.append('(');
        generateParenthesisCore(n + 1);
        sb.deleteCharAt(sb.length() - 1);
        stack.pop();

        // 处理 ')'
        if (!stack.isEmpty() && stack.pop() == '(') {
            sb.append(')');
            generateParenthesisCore(n + 1);
            sb.deleteCharAt(sb.length() - 1);
            stack.push('(');
        }
    }
}

class Solution2 {
    private List<String> result = new ArrayList<>(1024);

    private int n;

    public List<String> generateParenthesis(int n) {

        this.n = n;

        generateParenthesisCore("", 0, 0);

        return result;
    }

    private void generateParenthesisCore(String curStr, int left, int right) {
        if (right == n) {
            result.add(curStr);
            return;
        }

        if (left < n) {
            generateParenthesisCore(curStr + '(', left + 1, right);
        }
        if (right < left) {
            generateParenthesisCore(curStr + ')', left, right + 1);
        }
    }
}

class Solution3 {
//    private List<String> result = new ArrayList<>(1024);
    private List<Integer> result = new ArrayList<>(1024);

    private int n;

    public List<String> generateParenthesis(int n) {

        this.n = n;

        generateParenthesisCore(0, 0, 0);

//        return result;
        List<String> list = new ArrayList<>(50);
        for(Integer integer : result){
            String str = Integer.toBinaryString(integer);
            str = str.replace('1','(');
            str = str.replace('0',')');
            list.add(str);
        }
        return list;
    }

    private void generateParenthesisCore(int curStr, int left, int right) {
        if (right == n) {
            result.add(curStr);
            return;
        }

        if (left < n) {
            generateParenthesisCore((curStr << 1) + 1, left + 1, right);
        }
        if (right < left) {
            generateParenthesisCore(curStr << 1, left, right + 1);
        }
    }
}
