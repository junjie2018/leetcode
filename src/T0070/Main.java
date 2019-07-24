package T0070;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().climbStairs(44));
    }
}

class Solution {
    public int climbStairs(int n) {
        return climbStairsCore(n);
    }

    private int climbStairsCore(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsCore(n - 2) + climbStairs(n - 1);
    }

}

class Solution2 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int pre = 2, ppre = 1;
        for (int i = 3; i < n; i++) {
            int tmp = pre + ppre;
            ppre = pre;
            pre = tmp;
        }
        return pre + ppre;
    }
}