package T0315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Solution2().countSmaller(new int[]{
                1, 3, 5, 7, 9, 2, 4, 6, 8, 10
        });
    }
}

/**
 * 超出时间限制
 */
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) count++;
            }
            result.add(count);
        }

        return result;
    }
}

class Solution2 {

    public List<Integer> countSmaller(int[] nums) {
        counts = new int[nums.length];
        indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }

        countSmallerCore(nums, 0, nums.length - 1);

        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }

    private int[] counts;
    private int[] indexes;

    private void countSmallerCore(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        countSmallerCore(nums, start, mid);
        countSmallerCore(nums, mid + 1, end);

        /*
            1.对于左边数组中的每个元素，在右边数组中寻找比它大的数字的位置
            2.根据位置，计算出比它小的元素个个数
            3.根据左边元素的位置，在indexes中寻找在原数组中的位置
            4.更新counts的值
        */
        // 先用while验证一下逻辑是否正确

        int m = mid, n = end;
        while (m >= start) {
            while (n >= mid + 1) {
                if (nums[n] < nums[m]) {
                    counts[indexes[m]] += n - mid;
                    break;
                }
                n--;
            }
            m--;
        }

        int idx = 0;
        int idxLeft = start, idxRight = mid + 1;
        int[] tmpCount = new int[end - start + 1];
        int[] tmpIndexes = new int[end - start + 1];

        while (idxLeft <= mid && idxRight <= end) {
            if (nums[idxLeft] < nums[idxRight]) {
                tmpIndexes[idx] = indexes[idxLeft];
                tmpCount[idx++] = nums[idxLeft++];
            } else {
                tmpIndexes[idx] = indexes[idxRight];
                tmpCount[idx++] = nums[idxRight++];
            }
        }

        while (idxLeft <= mid) {
            tmpIndexes[idx] = indexes[idxLeft];
            tmpCount[idx++] = nums[idxLeft++];
        }

        while (idxRight <= end) {
            tmpIndexes[idx] = indexes[idxRight];
            tmpCount[idx++] = nums[idxRight++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = tmpCount[i - start];
            indexes[i] = tmpIndexes[i - start];
        }
    }
}