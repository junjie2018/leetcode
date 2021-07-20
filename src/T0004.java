public class T0004 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return findMedianSortedArrays02(nums1, nums2);
        }

        public double findMedianSortedArrays02(int[] nums1, int[] nums2) {
            int target = (nums1.length + nums2.length) / 2;
            boolean evenFlag = (nums1.length + nums2.length) % 2 == 0;

            int count = 0;

            int result = 0;
            int idx1 = 0, idx2 = 0;

            while (idx1 < nums1.length && idx2 < nums2.length) {
                if (nums1[idx1] < nums2[idx2]) {
                    ++idx1;
                } else {
                    ++idx2;
                }
                ++count;
                if (count == target) {

                }
            }
            while (idx1 < nums1.length) {
                ++idx1;
                ++count;
                if (count == target) {
                    if (evenFlag) {
                        return (nums1[idx1] + nums1[idx1 - 1]) / 2.0;
                    }
                }
            }
            while (idx2 < nums2.length) {
                ++idx2;
                ++count;
                if (count == target) {
                    if (evenFlag) {
                        return (nums2[idx2] + nums2[idx2 - 1]) / 2.0;
                    } else {
                        return nums2[idx2 - 1];
                    }
                }
            }
        }
    }
}
