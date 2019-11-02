package T0461;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4));
    }
}

class Solution {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int count = 0;
        while (tmp != 0) {
            if ((tmp & 1) != 0) count++;
            tmp = tmp >> 1;
        }
        return count;
    }
}
