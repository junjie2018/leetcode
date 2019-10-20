package T0231;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(-2147483648));
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            if (n == 1 << i) return true;
        }
        return false;
    }
}
