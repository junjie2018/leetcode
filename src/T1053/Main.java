package T1053;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
//        CommonUtils.show(new Solution().prevPermOpt1(CommonUtils.createInt1a("[3,2,1]")));
        CommonUtils.show(new Solution().prevPermOpt1(CommonUtils.createInt1a("[1,9,4,6,7]")));
//        CommonUtils.show(new Solution().prevPermOpt1(CommonUtils.createInt1a("[3,1,1,3]")));

    }
}

class Solution {
    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                int idx = i + 1;
                int pre = A[i];
                for (int j = i + 1; j <= len - 1; j++) {
                    if (A[j] < A[i]) {
                        if (A[j] != pre) idx = j;
                        pre = A[j];
                    } else {
                        break;
                    }
                }
                if (idx == len) idx = len - 1;
                swap(A, i, idx);
                break;
            }
        }
        return A;
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
