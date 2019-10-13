package T0089;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().grayCode(2));
    }
}

/*
    G(n) =  B(n) XOR B(n+1)
        B(n)：n的二进制形式
  */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int end = (int) Math.pow(2, n);
        for (int i = 0; i < end; i++) {
            result.add((i >> 1) ^ i);
        }
        return result;
    }
}
