package T0013;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}

class Solution {
    public int romanToInt(String s) {

        /*
            I V X L C D M
            IV IX XL XC CD CM
         */

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'I':
                    if(i+1 < s.length() && (s.charAt(i+1)=='V' || s.charAt(i+1) == 'X')){
                        sum -= 2;
                    }
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if(i+1 < s.length() && (s.charAt(i+1)=='L' || s.charAt(i+1) == 'C')){
                        sum -= 20;
                    }
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if(i+1 < s.length() && (s.charAt(i+1)=='D' || s.charAt(i+1) == 'M')){
                        sum -= 200;
                    }
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }
}
