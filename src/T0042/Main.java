package T0042;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution3().trap(new int[]{2, 0, 2}));
    }
}

class Solution {
    public int trap(int[] height) {
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        int sum = 0;
        for (int i = 1; i <= height.length - 2; i++) {
            int tall = Math.min(getLeftTall(height, i), getRightTall(height, i));
            if (tall - height[i] > 0) {
                sum += (tall - height[i]);
            }
        }
        return sum;
    }

    public int getLeftTall(int[] height, int index) {
        int tall = Integer.MIN_VALUE;
        for (int i = index - 1; i >= 0; i--) {
            if (height[i] > tall) {
                tall = height[i];
            }
        }
        return tall;
    }

    public int getRightTall(int[] height, int index) {
        int tall = Integer.MIN_VALUE;
        for (int i = index + 1; i <= height.length - 1; i++) {
            if (height[i] > tall) {
                tall = height[i];
            }
        }
        return tall;
    }

}

class Solution2 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        // [0,1,0,2,1,0,1,3,2,1,2,1]


        int len = height.length;
        int[] leftTall = new int[len];
        int[] rightTall = new int[len];

        leftTall[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftTall[i] = height[i] > leftTall[i - 1] ? height[i] : leftTall[i - 1];
        }

        rightTall[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightTall[i] = height[i] > rightTall[i + 1] ? height[i] : rightTall[i + 1];
        }

        int sum = 0;
        for (int i = 1; i <= len - 2; i++) {
            int delta = Math.min(leftTall[i], rightTall[i]) - height[i];
            if (delta >= 0) {
                sum += delta;
            }
        }

        return sum;
    }
}

class Solution3 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int len = height.length;

        int sum = 0;
        int left = 1, right = len - 2;
        int leftTall = height[0], rightTall = height[len - 1];
        while (left <= right) {
            leftTall = Math.max(height[left], leftTall);
            rightTall = Math.max(height[right], rightTall);

            if (leftTall < rightTall) {
                sum += leftTall - height[left];
                left++;
            } else {
                sum += rightTall - height[right];
                right--;
            }
        }

        return sum;
    }
}
