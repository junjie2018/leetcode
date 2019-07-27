package T0735;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{
//                -2, -1, 1, 2
//                8, -8
                -2, 1, -1, -2
        })));
    }
}

class Solution {

    private static final int SIZE = 1024;

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int[] res = new int[SIZE];
        outer:
        for (int i = 0; i < asteroids.length; i++) {
            int curAsteroid = asteroids[i];

            if (curAsteroid > 0) {
                stack.push(curAsteroid);
                continue;
            }

            while (curAsteroid < 0 && stack.size() > 0) {
                int topAsteroid = stack.peek();
                if (-curAsteroid < topAsteroid) {
                    continue outer;
                }
                if (-curAsteroid == topAsteroid) {
                    stack.pop();
                    continue outer;
                }
                stack.pop();
            }
            if (stack.size() <= 0) {
                res[index++] = curAsteroid;
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            res[index++] = stack.get(i);
        }

        return Arrays.copyOf(res, index);
    }
}