package T0050;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution3().myPow(2.00000, -2147483648));
    }
}

class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }
}

class Solution2 {
    public double myPow(double x, int n) {
        boolean symbol = n > 0;

        n = Math.abs(n);

        double sum = 1;
        for (int i = 0; i < n; i++) {
            sum *= x;
        }

        return symbol ? sum : 1 / sum;
    }
}

class Solution3 {
    public double myPow(double x, int n) {

        if (x == 1 || n == 0) {
            return 1.0;
        }



        if (n == Integer.MIN_VALUE) {
            return 1 / (myPowCore(x, -(n + 1)) * x);
        }


        boolean symbol = n > 0;

        n = Math.abs(n);

        return symbol ? myPowCore(x, n) : 1 / myPowCore(x, n);
    }

    public double myPowCore(double x, int n) {
        if (n == 1) {
            return x;
        }

        double result = myPowCore(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }
}
