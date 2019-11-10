package T0709;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char aChar = str.charAt(i);
            if (aChar >= 'A' && aChar <= 'Z') {
                sb.append((char) ('a' + (aChar - 'A')));
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }
}
