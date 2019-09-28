package T0605;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    }
}

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int pre = 1;
        int count = 0;
        boolean isHead = true;
        for (int num : flowerbed) {
            switch (num) {
                case 0:
                    count++;
                    break;
                case 1:
                    if (pre == 0) {
                        n -= isHead ? count / 2 : (count - 1) / 2;
                        if (n <= 0) return true;
                        count = 0;
                    }
                    isHead = false;
                    break;
            }
            pre = num;
        }
        if (pre == 0) {
            n -= isHead ? (count + 1) / 2 : count / 2;
        }
        return n <= 0;
    }
}