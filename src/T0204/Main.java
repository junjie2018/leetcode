package T0204;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int countPrimes(int n) {

        int result = 0;

        boolean[] flags = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!flags[i]) {
                result++;
                for (int j = i + i; j < n; j += i) {
                    flags[j] = true;
                }
            }
        }
        return result;
    }
}
