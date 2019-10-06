package T1175;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numPrimeArrangements(100));
    }
}

class Solution {
    public int numPrimeArrangements(int n) {

        if (n == 1) return 1;

        int primeCount = getPrimeCount(n);
        int normalCount = n - primeCount;

        int i = 2;
        long sum = 1;
        while (i <= primeCount && i <= normalCount) {
            sum = (sum * i) % 1000000007;
            sum = (sum * i) % 1000000007;
            i++;
        }

        while (i <= primeCount || i <= normalCount) {
            sum = (sum * i) % 1000000007;
            i++;
        }

        return (int) sum;
    }

    int getPrimeCount(int n) {

        int[] primeNums = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        int res = Arrays.binarySearch(primeNums, n);
        if (res >= 0) {
            return res + 1;
        } else {
            return -(res + 1);
        }
    }
}