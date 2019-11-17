package T0733;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        new Solution().floodFill(
//                CommonUtils.createInt2a("[[0,1,1],[0,1,0]]"), 1, 1, 1
                CommonUtils.createInt2a("[[0,1,1],[0,1,1]]"), 1, 1, 1
        );
    }
}

/*
    为了完成上色工作，从初始坐标开始:
        1.记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点（像素值需要相同）
        2.接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。
        3.将所有有记录的像素点的颜色值改为新的颜色值。
 */
class Solution {
    private int[][] image;
    private int oldColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.oldColor = image[sr][sc];

        floodFill(sr, sc);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] < 0) image[i][j] = newColor;
            }
        }

        return image;
    }

    private void floodFill(int r, int c) {

        if (r < 0
                || r >= image.length
                || c < 0
                || c >= image[0].length
                || image[r][c] != oldColor) {
            return;
        }

        image[r][c] = -1;
        floodFill(r - 1, c);
        floodFill(r + 1, c);
        floodFill(r, c - 1);
        floodFill(r, c + 1);
    }
}
