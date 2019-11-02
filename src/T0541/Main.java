package T0541;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 2));
    }
}

class Solution {
    public String reverseStr(String s, int k) {

        int idx = 0, count = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < s.length()) {
            for (int i = 0; i < k; i++) {
                if (count % 2 == 0) {
                    if (idx + k - i - 1 >= s.length()) continue;
                    sb.append(s.charAt(idx + k - i - 1));
                } else {
                    if (idx + i >= s.length()) break;
                    sb.append(s.charAt(idx + i));
                }
            }
            count++;
            idx += k;
        }
        return sb.toString();
    }
}
