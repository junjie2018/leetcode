package T0762;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countPrimeSetBits(int L, int R) {
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        int res = 0;
        for (int i = L; i <= R; i++) {
            int t = Integer.bitCount(i);
            res += primes[t];
        }
        return res;
    }
}