package T0492;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] constructRectangle(int area) {
        int target = (int) Math.floor(Math.sqrt(area));

        for (int i = target; i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }

        return null;

    }
}