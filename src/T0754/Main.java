package T0754;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reachNumber(2));
    }
}

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return target % 2 == 0 ? k : k + 1 + k%2;
    }
}