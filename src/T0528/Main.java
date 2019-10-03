package T0528;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    int[] weights;
    int sum;
    Random rand;

    public Solution(int[] w) {
        this.weights = new int[w.length];
        this.rand = new Random();

        weights[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            weights[i] = weights[i - 1] + w[i];
        }

        this.sum = weights[weights.length - 1];
    }

    public int pickIndex() {
        int guess = rand.nextInt(sum) + 1;
        int pos = Arrays.binarySearch(weights, guess);
        return pos < 0 ? -(pos + 1) : pos;
    }
}

