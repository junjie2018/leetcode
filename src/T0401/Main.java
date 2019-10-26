package T0401;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<String> readBinaryWatch(int num) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (getOneCount(i) + getOneCount(j) == num) {
                    result.add(String.format("%2d:%02d", i, j));
                }
            }
        }

        return result;
    }

    int getOneCount(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
