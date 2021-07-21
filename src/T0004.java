import Common.CommonUtils;

import java.util.Arrays;

public class T0004 {


    public static void main(String[] args) {
        System.out.println(new T0004().new Solution().findMedianSortedArrays(
                CommonUtils.createIntArrayFromString("[0,0,0,0,0]"),
                CommonUtils.createIntArrayFromString("[-1,0,0,0,0,0,1]")
        ));
    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return findMedianSortedArrays03(nums1, nums2);
        }

        /*
            m + n
            按顺序扫描nums和nums，当扫描的元素数恰好为中位数要求的元素数时得出结果
         */
        public double findMedianSortedArrays01(int[] nums1, int[] nums2) {

            // (5 + 5) / 2 = 5 => 5 6
            // (5 + 4) / 2 = 4 => 5
            boolean oddFlag = (nums1.length + nums2.length) % 2 == 1;

            if (oddFlag) {
                int curNum;
                int count = 0;
                int idx1 = 0, idx2 = 0;
                int target = (nums1.length + nums2.length) / 2 + 1;
                while (idx1 < nums1.length && idx2 < nums2.length) {
                    if (nums1[idx1] < nums2[idx2]) {
                        curNum = nums1[idx1++];
                    } else {
                        curNum = nums2[idx2++];
                    }
                    ++count;
                    if (count == target) {
                        return curNum;
                    }
                }
                while (idx1 < nums1.length) {
                    ++count;
                    if (count == target) {
                        return nums1[idx1];
                    }
                    ++idx1;
                }
                while (idx2 < nums2.length) {
                    ++count;
                    if (count == target) {
                        return nums2[idx2];
                    }
                    ++idx2;
                }
            } else {
                int curNum;
                int count = 0;
                boolean targetSecondFlag = false;
                int target = (nums1.length + nums2.length) / 2;
                int[] results = new int[2];
                int idx1 = 0, idx2 = 0;
                while (idx1 < nums1.length && idx2 < nums2.length) {
                    if (nums1[idx1] < nums2[idx2]) {
                        curNum = nums1[idx1++];
                    } else {
                        curNum = nums2[idx2++];
                    }
                    ++count;
                    if (count == target) {
                        if (!targetSecondFlag) {
                            results[0] = curNum;
                            ++target;
                            targetSecondFlag = true;
                        } else {
                            results[1] = curNum;
                            return (results[0] + results[1]) / 2.0;
                        }
                    }
                }
                while (idx1 < nums1.length) {
                    ++count;
                    if (count == target) {
                        if (!targetSecondFlag) {
                            results[0] = nums1[idx1];
                            ++target;
                            targetSecondFlag = true;
                        } else {
                            results[1] = nums1[idx1];
                            return (results[0] + results[1]) / 2.0;
                        }
                    }
                    ++idx1;
                }
                while (idx2 < nums2.length) {
                    ++count;
                    if (count == target) {
                        if (!targetSecondFlag) {
                            results[0] = nums2[idx2];
                            ++target;
                            targetSecondFlag = true;
                        } else {
                            results[1] = nums2[idx2];
                            return (results[0] + results[1]) / 2.0;
                        }
                    }
                    ++idx2;
                }
            }

            return 0.0;
        }

        /*
            (m + n)*log(m + n)
            将两个数组拼接在一起，排好序后，直接计算出中位数
         */
        public double findMedianSortedArrays02(int[] nums1, int[] nums2) {
            int[] nums = new int[nums1.length + nums2.length];

            System.arraycopy(nums1, 0, nums, 0, nums1.length);
            System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);

            Arrays.sort(nums);

            return nums.length % 2 != 0 ?
                    nums[nums.length / 2] :
                    (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;

        }

        // log(m + n)
        public double findMedianSortedArrays03(int[] nums1, int[] nums2){
            return 0.0;
        }
    }
}
