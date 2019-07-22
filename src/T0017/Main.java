package T0017;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> result = new Solution3().letterCombinations("23");
        System.out.println(result.toString());
    }
}

class Solution {
    private List<String> result = new ArrayList<>(100);
    private Stack stack = new Stack();
    private Map<Character, List<Character>> map = new HashMap<>();
    {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    private int length;
    private String digits;
    public List<String> letterCombinations(String digits) {

        if(digits==null || digits.length()==0){
            return Collections.emptyList();
        }

        // 这个地方利用类成员变量，防止方法间各种传参，导致混乱
        this.length = digits.length();
        this.digits = digits;

        letterCombinationsCore(0);

        return result;
    }

    public void letterCombinationsCore(int i){
        if(i>=length){
            result.add(stack.getString());
            return;
        }

        List<Character> list = map.get(digits.charAt(i));
        for(char c : list){
            stack.push(c);
            letterCombinationsCore(i+1);
            stack.pop();
        }
    }

    static class Stack{
        StringBuilder sb = new StringBuilder();
        void pop(){
            sb.deleteCharAt(sb.length()-1);
        }
        void push(char c){
            sb.append(c);
        }
        String getString(){
            return sb.toString();
        }
    }
}

class Solution2 {
    private List<String> result = new ArrayList<>(100);
    private Stack stack = new Stack();
    private Map<Character, String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    private int length;
    private String digits;
    public List<String> letterCombinations(String digits) {

        if(digits==null || digits.length()==0){
            return Collections.emptyList();
        }

        // 这个地方利用类成员变量，防止方法间各种传参，导致混乱
        this.length = digits.length();
        this.digits = digits;

        letterCombinationsCore(0);

        return result;
    }

    public void letterCombinationsCore(int i){
        if(i>=length){
            result.add(stack.getString());
            return;
        }

        String str = map.get(digits.charAt(i));
        for (int j = 0; j < str.length(); j++) {
            stack.push(str.charAt(j));
            letterCombinationsCore(i+1);
            stack.pop();
        }
    }

    static class Stack{
        StringBuilder sb = new StringBuilder();
        void pop(){
            sb.deleteCharAt(sb.length()-1);
        }
        void push(char c){
            sb.append(c);
        }
        String getString(){
            return sb.toString();
        }
    }
}

class Solution3 {
    private List<String> result = new ArrayList<>(100);
    private StringBuilder sb = new StringBuilder();
    private Map<Character, String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }


    public List<String> letterCombinations(String digits) {

        if(digits==null || digits.length()==0){
            return Collections.emptyList();
        }

        letterCombinationsCore(digits,0);

        return result;
    }

    public void letterCombinationsCore(String digits, int i){
        if(i>=digits.length()){
            result.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(i));
        for (int m = 0; m < str.length(); m++) {
            sb.append(str.charAt(m));
            letterCombinationsCore(digits,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

class Solution4 {

    private Map<Character, String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {

        if(digits==null || digits.length()==0){
            return Collections.emptyList();
        }

        Queue<String> queue = new LinkedList<>();

        return null;
    }
}


