package T0069;

public class Main {
    public static void main(String[] args) {
        new Solution4().mySqrt(2147395599);
    }
}

class Solution {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}

class Solution2 {
    public int mySqrt(int x) {
        long i = 1;
        while (i * i <= x) {
            i++;
        }
        return (int) (i - 1);
    }
}

class Solution3 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long left = 1, right = x;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            long val = mid * mid;

            if (val < x) {
                left = mid;
            } else if (val > x) {
                right = mid;
            } else {
                return (int) mid;
            }

        }
        return (int) left;
    }
}

class Solution4 {
    public int mySqrt(int x) {
        long i = 1;
        int count = 1;
        int delta = 3;
        while (i <= x) {
            i += delta;
            delta += 2;
            count++;
        }
        return count - 1;
    }
}

