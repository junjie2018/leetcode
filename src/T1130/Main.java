package T1130;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().mctFromLeafValues(
//                CommonUtils.createInt1a("[6,2,4]")
                CommonUtils.createInt1a("[15,13,5,3,15]")
        ));
    }
}


class Solution {
    public int mctFromLeafValues(int[] arr) {

        List<Integer> nums = new ArrayList<>();
        for (int i : arr) {
            nums.add(i);
        }

        int sum = 0;
        while (nums.size() != 1) {

            int minIdx = 1;
            int min = nums.get(1) * nums.get(0);

            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) * nums.get(i - 1) < min) {
                    minIdx = i;
                    min = nums.get(i) * nums.get(i - 1);
                }
            }

            sum += min;
            nums.set(minIdx - 1, Math.max(nums.get(minIdx), nums.get(minIdx - 1)));
            nums.remove(minIdx);
        }

        return sum;
    }
}
