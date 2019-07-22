package T0020;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().isValid("{[]}"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '[': case '{': case '(':
                    stack.push(s.charAt(i));
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}

class Solution2 {
    public boolean isValid(String s) {
        Stack stack = new Stack(10000);
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '[': case '{': case '(':
                    stack.push(s.charAt(i));
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    static class Stack{
        char[] chars = null;
        int i = 0; //指向当前空位

        Stack(int size){
            chars=new char[size];
        }

        void push(char c){
            chars[i++] = c;
        }

        char pop(){
            if(i==0){
                return 0;
            }
            return chars[--i];
        }

        public boolean isEmpty(){
            return i==0;
        }
    }
}
