package T0054;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(CommonUtils.createInt2a(
//                "[[1,2,3],[4,5,6],[7,8,9]]"
//                "[[6,9,7]]"
                "[[1,2],[3,4]]"
        )));
    }
}

class Solution {

    private List<Integer> result;

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Collections.emptyList();

        this.result = new ArrayList<>();

        spiralOrderCore(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1);
        return result;
    }

    private void spiralOrderCore(int[][] matrix, int left, int right, int top, int bottom) {
        if (left > right || top > bottom) {
            return;
        }

        if (left == right) {
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][left]);
            }
            return;
        }
        if (top == bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            return;
        }


        // 从左到右
        for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
        }
        ++top;

        // 从上到下
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        --right;

        // 从右到左
        for (int i = right; i >= left; i--) {
            result.add(matrix[bottom][i]);
        }
        --bottom;

        // 从下到上
        for (int i = bottom; i >= top; i--) {
            result.add(matrix[i][left]);
        }
        ++left;

        spiralOrderCore(matrix, left, right, top, bottom);
    }
}
