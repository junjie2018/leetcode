package T0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        for (int i = 1; i <= 24; i++) {
//            new Solution().getPermutation(4, i);
//        }
        new Solution().getPermutation(4, 9);
    }
}

class Solution {

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] maps = new int[]{0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        StringBuilder sb = new StringBuilder();
        int tmp = k - 1;
        while (n > 1) {
            int index = tmp / maps[n - 1];
            sb.append(list[index]);

            list[index] = 10;
            Arrays.sort(list, 0, n + 1);

            tmp = tmp % maps[n - 1];
            n--;
        }
        sb.append(list[0]);


        return sb.toString();
    }
}

class Solution2 {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int cursor = n - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (cursor != 0) {
            int factorial = getFactorial(cursor);
            int value = (k - 1) / factorial;
            sb.append(list.get(value));
            list.remove(value);
            k = (k - 1) % factorial + 1;
            cursor--;
        }
        sb.append(list.get(0));
        return sb.toString();
    }

    private int getFactorial(int x) {
        int temp = 1;
        for (int i = 1; i <= x; i++) {
            temp *= i;
        }
        return temp;
    }
}

class Solution3 {

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

//        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> list = new ArrayList<>(10);
//        IntStream.range(1, n + 1).forEach(list::add);
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        int[] maps = new int[]{0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        StringBuilder sb = new StringBuilder();
        int tmp = k - 1;
        while (n > 1) {
            int index = tmp / maps[n - 1];
            sb.append(list.remove(index));

            tmp = tmp % maps[n - 1];
            n--;
        }
        sb.append(list.remove(0));

        return sb.toString();
    }
}