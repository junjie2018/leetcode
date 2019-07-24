package T0004;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int target = (nums1.length + nums2.length) / 2;

        int m1, m2, elements;
        int l1 = 0, r1 = nums1.length - 1;
        int l2 = 0, r2 = nums2.length - 1;
        while (true) {

            m1 = (l1 + r1) / 2;
            m2 = (l2 + r2) / 2;

            // 处理第一行数据
            if (nums1[m1] <= nums2[m2]) {
                elements = m1 - l1 + 1;

                if (elements == target) {
                    return nums1[m1];
                } else if (elements > target) {
                    r1 = m1;
                } else {
                    l1 = m1;
                }
            }
            // 处理第二行数据
            else {
                elements = m2 - l2 + 1;

                if (elements == target) {
                    return nums2[m2];
                } else if (elements > target) {
                    r2 = m2;
                } else {
                    l2 = m2;
                }
            }
        }
    }
}

class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);

        Arrays.sort(nums);

        return nums.length % 2 == 1 ? nums[nums.length / 2] : (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
    }
}