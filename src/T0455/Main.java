package T0455;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int idx = 0;
        int res = 0;
        for (int aG : g) {
            while (idx < s.length && s[idx] < aG) {
                idx++;
            }
            if (idx >= s.length) break;
            res++;
            idx++;
        }

        return res;
    }
}
