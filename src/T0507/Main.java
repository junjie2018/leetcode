package T0507;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().checkPerfectNumber(6));
    }
}

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int target = (int) Math.floor(Math.sqrt(num) + 1);
        int sum = 0;
        for (int i = 2; i < target; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return (sum + 1) == num;
    }
}