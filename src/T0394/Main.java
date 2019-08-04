package T0394;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
    }
}

class Solution {
    public String decodeString(String s) {
        return decodeStringCore(s);
    }

    private int index = 0;

    private String decodeStringCore(String s) {

        StringBuilder result = new StringBuilder();

        int count = 0;
        while (index < s.length()) {
            char aChar = s.charAt(index++);
            switch (aChar) {
                case '[':
                    String tmp = decodeStringCore(s);
                    while (count > 0) {
                        result.append(tmp);
                        count--;
                    }
                    break;
                case ']':
                    return result.toString();
                default:
                    if (aChar >= '0' && aChar <= '9') {
                        count = count * 10 + (aChar - '0');
                    } else {
                        result.append(aChar);
                    }
                    break;
            }
        }
        return result.toString();
    }
}
