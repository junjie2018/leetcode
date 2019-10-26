package T0344;

public class Main {
    public static void main(String[] args) {

    }
}


class Solution {
    public void reverseString(char[] s) {

        if (s == null || s.length == 0) return;

        int len = s.length;
        int mid = len % 2 == 0 ? len / 2 - 1 : len / 2;

        for (int i = 0; i <= mid; i++) {
            char tmp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = tmp;
        }

    }
}