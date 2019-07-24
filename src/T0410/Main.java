package T0410;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().countM(new int[]{7, 2, 5, 10, 8}, 2));
//        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
//        System.out.println(new Solution().splitArray(new int[]{1, 2147483647}, 2));
//        System.out.println(new Solution().splitArray(new int[]{1, 4, 4}, 2));
        System.out.println(new Solution().splitArray(new int[]{2, 3, 1, 1, 1, 1, 1}, 5));
    }
}

class Solution {
    public int splitArray(int[] nums, int m) {
        long max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }

        long left = max, right = sum;
        while (left < right) {
            long mid = (left + right) / 2;
            long tmp = countM(nums, mid);
            if (tmp > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) left;
    }

    /**
     * 只能统计最少划分为几组
     */
    public long countM(int[] nums, long target) {
        long count = 0, sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((sum += nums[i]) > target) {
                sum = nums[i];
                count++;
            }
        }
        return count + 1;
    }
}

class Solution2 {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }

        int left = max, right = sum;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            int tmp = countM(nums, mid);
            if (tmp > m) {
                left = mid;
            } else if (tmp <= m) {
                right = mid;
            }
        }

        return right;
    }

    public int countM(int[] nums, int target) {
        int count = 0, sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((sum += nums[i]) > target) {
                sum = nums[i];
                count++;
            }
        }
        return count + 1;
    }
}