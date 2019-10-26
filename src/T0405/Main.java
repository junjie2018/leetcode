package T0405;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().toHex(26));
    }
}

class Solution {
    public String toHex(int num) {
        String numStr = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = numStr.length() - 4; i >= -3; i -= 4) {
            int endIdx = i + 4;
            int beginIdx = i < 0 ? 0 : i;
            int val = Integer.parseInt(numStr.substring(beginIdx, endIdx), 2);
            if (val < 10) {
                sb.append(val);
            } else {
                sb.append((char) ('a' + val - 10));
            }
        }
        return sb.reverse().toString();
    }
}