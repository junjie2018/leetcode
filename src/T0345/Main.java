package T0345;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String reverseVowels(String s) {
        int idx = 0;
        char[] chars = new char[8192];
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            if (aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u'
                    || aChar == 'A' || aChar == 'E' || aChar == 'I' || aChar == 'O' || aChar == 'U') {
                chars[idx++] = aChar;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            if (aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u'
                    || aChar == 'A' || aChar == 'E' || aChar == 'I' || aChar == 'O' || aChar == 'U') {
                sb.append(chars[--idx]);
            } else {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }
}