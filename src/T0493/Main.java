package T0493;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reversePairs(new int[]{5, 4, 3, 2, 1}));
    }
}

class Solution {

    private int[] nums;

    public int reversePairs(int[] nums) {

        this.nums = nums;

        reversePairsCore(0, nums.length - 1);

        return count;
    }

    private void reversePairsCore(int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;

        reversePairsCore(left, mid);
        reversePairsCore(mid + 1, right);

        merge(left, mid, mid + 1, right);
    }

    private int count = 0;

    private void merge(int s1, int e1, int s2, int e2) {
        int[] tmp = new int[e2 - s1 + 1];

        int idx = 0;
        int p = s1, q = s2;

        while (p <= e1 && q <= e2) {
            if ((long) nums[p] > (long) 2 * nums[q]) {
                count += e2 - q + 1;
                p++;
            } else {
                q++;
            }
        }

        p = s1;
        q = s2;
        while (p <= e1 && q <= e2) {
            if (nums[p] > nums[q]) {
                tmp[idx++] = nums[p];
                p++;
            } else {
                tmp[idx++] = nums[q];
                q++;
            }
        }
        while (p <= e1) {
            tmp[idx++] = nums[p++];
        }
        while (q <= e2) {
            tmp[idx++] = nums[q++];
        }

        System.arraycopy(tmp, 0, nums, s1, tmp.length);
    }
}