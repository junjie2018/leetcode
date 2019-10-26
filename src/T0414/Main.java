package T0414;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, sencond = Long.MIN_VALUE, third = Long.MIN_VALUE;

        for (int num : nums) {
            if (num >= first) {
                if (num == first) continue;
                third = sencond;
                sencond = first;
                first = num;
            } else if (num >= sencond) {
                if (num == sencond) continue;
                third = sencond;
                sencond = num;
            } else if (num > third) {
                third = num;
            }
        }

        return (int) (third != Long.MIN_VALUE ? third : first);
    }
}
