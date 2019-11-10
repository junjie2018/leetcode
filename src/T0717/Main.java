package T0717;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        new Solution().isOneBitCharacter(CommonUtils.createInt1a("[1,0,0]"));
    }
}

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0;
        while (idx < bits.length) {
            if (bits[idx] == 0) {
                idx += 1;
                if (idx == bits.length) return true;
            } else idx += 2;
        }
        return false;
    }
}
