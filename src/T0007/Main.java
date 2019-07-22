package T0007;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1234));
    }
}

class Solution {
    public int reverse(int x) {
        int sum = 0;
        while(x!=0){
            int digit = x % 10;
            int temp = sum;
            sum = sum * 10 + digit;
            if((sum-digit)/10 != temp){
                return 0; // 内存溢出
            }
            x = x /10;
        }
        return sum;
    }
}