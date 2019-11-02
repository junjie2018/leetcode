package T0557;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        int start = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (start != -1) {
                    reverse(chars, start, i - 1);
                    start = -1;
                }
            } else {
                if (start == -1) {
                    start = i;
                }
            }
        }

        if (start != -1) {
            reverse(chars, start, s.length() - 1);
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        int mid = start + (end - start) / 2;
        while (start <= mid) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            ++start;
            --end;
        }
    }
}