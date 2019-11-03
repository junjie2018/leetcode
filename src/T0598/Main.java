package T0598;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxCount(int m, int n, int[][] ops) {

        int minA = m, minB = n;
        for (int[] op : ops) {
            if (op[0] < minA) minA = op[0];
            if (op[1] < minB) minB = op[1];
        }

        return minA * minB;
    }
}
