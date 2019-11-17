package T0788;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().rotatedDigits(857));
    }
}

class Solution {

    private int[] map = new int[]{0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNumber(i)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isGoodNumber(int num) {
        int tmp = num, sum = 0, ten = 1;
        while (tmp > 0) {
            if (map[tmp % 10] == -1) return false;
            sum = sum + map[tmp % 10] * ten;
            tmp /= 10;
            ten *= 10;
        }
        return sum != num;
    }
}
