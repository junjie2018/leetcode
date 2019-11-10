package T0697;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findShortestSubArray(CommonUtils.createInt1a(
                "[1]"
        )));
    }
}

class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        int len = nums.length;

        int pre = 0, max = 0;
        List<Integer> maxNum = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[pre]) continue;
            if (i - pre > max) {
                maxNum.clear();
                maxNum.add(arr[pre]);
                max = i - pre;
            } else if (i - pre == max) {
                maxNum.add(arr[pre]);
            }
            pre = i;
        }

        if (len - pre > max) {
            maxNum.clear();
            maxNum.add(arr[pre]);
        } else if (len - pre == max) {
            maxNum.add(arr[pre]);
        }


        int res = Integer.MAX_VALUE;
        for (Integer num : maxNum) {
            int dis = lastIndexOf(nums, num) - indexOf(nums, num) + 1;
            if (dis < res) res = dis;
        }

        return res;
    }

    private int indexOf(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    private int lastIndexOf(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}
