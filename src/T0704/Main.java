package T0704;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int search(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);
        return res >= 0 ? res : -1;
    }
}
