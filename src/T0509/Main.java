package T0509;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int fib(int N) {
        int curr = 0, next = 1;
        while (N-- > 0) {
            next = next + curr;
            curr = next - curr;
        }
        return curr;
    }
}