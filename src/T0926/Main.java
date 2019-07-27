package T0926;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().minFlipsMonoIncr("010110"));
//        System.out.println(new Solution().minFlipsMonoIncr("00110"));
        System.out.println(new Solution().minFlipsMonoIncr("0101100011"));
    }
}

class Solution {
    public int minFlipsMonoIncr(String S) {

        int one = 0, zero = 0;

        for (int i = S.length() - 1; i >= 0; i--) {
            switch (S.charAt(i)) {
                case '0':
                    one = one + 1;
                    zero = Math.min(one, zero);
                    break;
                case '1':
                    zero = Math.min(zero + 1, one);
                    break;
            }
        }

        return Math.min(one, zero);
    }
}
