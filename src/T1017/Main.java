package T1017;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().baseNeg2(5));
    }
}

class Solution {
    public String baseNeg2(int N) {
        StringBuilder res = new StringBuilder();
        while (N != 0) {
            res.append(N & 1);
            N = -(N >> 1);
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }
}
