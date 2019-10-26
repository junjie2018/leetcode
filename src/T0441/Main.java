package T0441;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(3));
    }
}

/*
    超出时间限制
 */
class Solution {
    public int arrangeCoins(int n) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (getSum(i) >= n) {
                if (getSum(i) == n) return i;
                else return i - 1;
            }
        }
        return 0;
    }

    private int getSum(int layer) {
        return (layer + layer * layer) / 2;
    }
}