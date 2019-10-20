package T0190;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().reverseBits(43261596));
        System.out.println(new Solution().reverseBits(Integer.parseUnsignedInt("11111111111111111111111111111101", 2)));
    }
}

class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        sb.reverse();
        while (sb.length() < 32) {
            sb.append('0');
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}