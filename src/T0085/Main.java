package T0085;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}

class Solution {
    private int rows, cols;

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        this.rows = matrix.length;
        this.cols = matrix[0].length;

        int[][] histogram = buildHistogram(matrix);

        int max = 0;
        for (int i = 0; i < rows; i++) {
            max = Math.max(max, largestRectangleArea(histogram[i]));
        }

        return max;
    }

    private int[][] buildHistogram(char[][] matrix) {

        int[][] histogram = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    histogram[i][j] = i - 1 >= 0 ? histogram[i - 1][j] + 1 : 1;
                } else {
                    histogram[i][j] = 0;
                }
            }
        }

        return histogram;
    }

    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int topIdx = stack.peek(), curIdx = i;

            while (topIdx > -1 && heights[curIdx] <= heights[topIdx]) {
                stack.pop();

                max = Math.max(max, heights[topIdx] * (curIdx - stack.peek() - 1));

                topIdx = stack.peek();
            }

            stack.push(curIdx);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return max;
    }
}

class Solution2 {
    private int rows, cols;

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        this.rows = matrix.length;
        this.cols = matrix[0].length;

        return buildHistogramAndGetMax(matrix);
    }

    private int buildHistogramAndGetMax(char[][] matrix) {

        int[] histogram = new int[cols];

        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j] = histogram[j] + 1;
                } else {
                    histogram[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(histogram));
        }

        return max;
    }

    public int largestRectangleArea(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int topIdx = stack.peek(), curIdx = i;

            while (topIdx > -1 && heights[curIdx] <= heights[topIdx]) {
                stack.pop();

                max = Math.max(max, heights[topIdx] * (curIdx - stack.peek() - 1));

                topIdx = stack.peek();
            }

            stack.push(curIdx);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return max;
    }
}