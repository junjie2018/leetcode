package T0504;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().convertToBase7(-7));
    }
}

class Solution {
    public String convertToBase7(int num) {
        if(num==0) return "0";

        StringBuilder sb = new StringBuilder();

        int tmp = Math.abs(num);
        while (tmp != 0) {
            sb.append(tmp % 7);
            tmp = tmp / 7;
        }

        String res = sb.reverse().toString();

        return num < 0 ? "-" + res : res;
    }
}
