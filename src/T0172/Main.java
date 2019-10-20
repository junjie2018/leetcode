package T0172;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
