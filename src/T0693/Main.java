package T0693;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().hasAlternatingBits(7));
    }
}

class Solution {
    public boolean hasAlternatingBits(int n) {
        if (1 == n) return true;
        String nStr = Integer.toBinaryString(n);

        char fir = nStr.charAt(0), sec = nStr.charAt(1);
        if (fir == sec) return false;
        for (int i = 0; i < nStr.length(); i++) {
            if (i % 2 == 0) {
                if (nStr.charAt(i) != fir) return false;
            } else {
                if (nStr.charAt(i) != sec) return false;
            }
        }
        return true;
    }
}
