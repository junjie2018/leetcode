package T1051;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int heightChecker(int[] heights) {
        int[] heights_bck = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights_bck);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != heights_bck[i]) {
                count++;
            }
        }
        return count;
    }
}

