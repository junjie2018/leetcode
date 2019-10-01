package T1081;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().smallestSubsequence("cbaacabcaaccaacababa"));
    }
}

class Solution {
    public String smallestSubsequence(String text) {
        int[] map = new int[26];
        for (char c : text.toCharArray()) map[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            map[c - 'a']--;
            if (stack.contains(c)) continue;

            if (!stack.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && map[stack.peek() - 'a'] > 0) {
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}

@SuppressWarnings("all")
class Solution2 {
    public String smallestSubsequence(String text) {
        int[] map = new int[26];

        for (int i = 0; i < text.length(); i++) {
            map[text.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {

            char aChar = text.charAt(i);

            map[aChar - 'a']--;

            if (stack.contains(aChar)) continue;

            while (stack.size() > 0 && aChar < stack.peek() && map[stack.peek() - 'a'] > 0) {
                stack.pop();
            }
            stack.push(aChar);
        }

        for (Character character : stack) {
            sb.append(character);
        }

        return sb.reverse().toString();
    }
}