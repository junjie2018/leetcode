package T0812;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public static double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i <= points.length - 1; i++) {
            for (int j = i + 1; j <= points.length - 1; j++) {
                for (int k = j + 1; k <= points.length - 1; k++) {

                    double temp = points[i][0] * (points[j][1] - points[k][1])
                            - points[i][1] * (points[j][0] - points[k][0])
                            + (points[j][0] * points[k][1] - points[j][1] * points[k][0]);
                    temp = Math.abs(temp);

                    if (0.5 * temp > max)
                        max = 0.5 * temp;
                }
            }
        }
        return max;
    }
}