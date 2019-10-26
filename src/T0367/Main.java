package T0367;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        if (1 == num) return true;

        int i = num / 2;

        while ((double) i * i > num) {
            i = (i + num / i) / 2;
        }

        return i * i == num;
    }
}

