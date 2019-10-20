package T0202;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isHappy(int n) {
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                int tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }
            if (sum == 4) return false;
            n = sum;
        }
        return true;
    }
}
