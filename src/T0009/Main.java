package T0009;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().isPalindrome(1001));
        System.out.println(new Solution2().isPalindrome(1221));
        System.out.println(new Solution2().isPalindrome(1122));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 ){
            return false;
        }

        if(x==0){
            return true;
        }

        if(x % 10==0){
            return false;
        }

        // 计算长度
        int temp = x , len = 0;
        while(temp!=0){
            len++;
            temp=temp/10;
        }

        int right = 0;
        int left = x;
        for (int i = 0; i < len/2; i++) {
            right = right * 10 + left % 10;
            left /= 10;
        }

        if(len%2==1){
            left /= 10;
        }

        return left==right;


    }
}

class Solution2 {
    public boolean isPalindrome(int x) {
        if(x < 0 ){
            return false;
        }

        if(x==0){
            return true;
        }

        if(x % 10==0){
            return false;
        }

        // 计算长度
        int div = 1; int num = x;
        while(num/div >= 10){
            div *= 10;
        }
        while(num != 0){
            int left = num / div;
            int right = num % 10;
            if(left != right){
                return false;
            }
            num =(num % div)/10;
            div/=100;
        }

        return true;


    }
}


