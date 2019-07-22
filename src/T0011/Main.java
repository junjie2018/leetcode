package T0011;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int area = Integer.MIN_VALUE;
        while (left < right) {

            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));

            if(height[left]>height[right]) right--;
            else if(height[left]<height[right]) left++;
            else {
                right--;
                left++;
            }
        }
        return area;
    }
}
