package T1027;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution5().longestArithSeqLength(new int[]{
//                3, 6, 9, 12
                83, 20, 17, 43, 52, 78, 68, 45
//                44, 46, 22, 68, 45, 66, 43, 9, 37, 30, 50, 67, 32, 47, 44, 11, 15, 4, 11, 6, 20, 64, 54, 54, 61, 63, 23, 43, 3, 12, 51, 61, 16, 57, 14, 12, 55, 17, 18, 25, 19, 28, 45, 56, 29, 39, 52, 8, 1, 21, 17, 21, 23, 70, 51, 61, 21, 52, 25, 28
//                25, 78, 45, 27, 75, 10, 90, 77, 60, 8, 43, 5, 55, 47, 57, 17, 8, 63, 18, 69, 63, 87, 35, 19, 78, 42, 25, 27, 24, 23, 88, 56, 14, 42, 16, 64, 8, 62, 48, 76, 66, 75, 59, 43, 16, 11, 15, 41, 20, 34, 69, 69, 58, 42, 22, 27, 79, 81, 63, 59, 57, 51, 11, 48, 89, 29, 30, 79, 40, 87, 17, 24, 16, 82, 18, 9, 86, 9, 90, 74, 17, 21, 8, 18, 24, 62, 8, 31, 84, 56, 70, 59, 55, 22, 44, 31, 11, 82, 80, 38
        }));
    }
}

/**
 * 超时时间限制
 */
class Solution {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        int longLength = 0;
        map.put(A[0], new HashMap<>());
        for (int i = 1; i < A.length; i++) {
            map.put(A[i], new HashMap<Integer, Integer>());
            for (int j = 0; j < i; j++) {
                int delta = A[i] - A[j];
                map.get(A[i]).put(delta, map.get(A[j]).getOrDefault(delta, 1) + 1);
                if (map.get(A[i]).get(delta) >= longLength) {
                    System.out.println(A[j] + "->" + A[i]);
                    longLength = map.get(A[i]).get(delta);
                }
            }
        }

        return longLength;
    }
}

/**
 * 这个方案挺好，但是给的A数组有重复数据，导致方案不可用
 */
class Solution2 {
    public int longestArithSeqLength(int[] A) {

        int[] flag = new int[10001];
        Arrays.fill(flag, -1);
        for (int i = 0; i < A.length; i++) {
            flag[A[i]] = i;
        }

        int maxLength = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int delta = A[j] - A[i];
                int length = 2;
                int tmp = j;
                while (A[tmp] + delta >= 0 && A[tmp] + delta <= 10000 && flag[A[tmp] + delta] > tmp) {
                    tmp = flag[A[tmp] + delta];
                    length++;
                }
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }
}

class Solution3 {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Integer>[] maps = new Map[A.length];

        int longLength = 0;
        maps[0] = new HashMap<>();
        for (int i = 1; i < A.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int delta = A[i] - A[j];
                maps[i].put(delta, maps[j].getOrDefault(delta, 1) + 1);
                if (maps[i].get(delta) >= longLength) {
                    longLength = maps[i].get(delta);
                }
            }
        }

        return longLength;
    }
}

class Solution4 {
    public int longestArithSeqLength(int[] A) {
        int[][] dp = new int[A.length][20001];
        if (A.length < 2)
            return 0;

        int max = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int step = A[i] - A[j] + 10000;
                if (dp[j][step] > 0) {
                    dp[i][step] = Math.max(dp[j][step] + 1, dp[i][step]);
                } else {
                    dp[i][step] = 2;
                }
                max = Math.max(max, dp[i][step]);
            }
        }
        return max;
    }
}

class Solution5 {
    public int longestArithSeqLength(int[] A) {

        ArrayList<Integer>[] flag = new ArrayList[10001];
        for (int i = 0; i < A.length; i++) {
            if (flag[A[i]] == null) {
                flag[A[i]] = new ArrayList<>();
            }
            flag[A[i]].add(i);
        }

        int maxLength = 2;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int delta = A[j] - A[i];
                int length = 2;
                int tmp = j;
                while (A[tmp] + delta >= 0 && A[tmp] + delta <= 10000 && flag[A[tmp] + delta] != null) {

                    boolean existIdx = false;
                    for (Integer idx : flag[A[tmp] + delta]) {
                        if (idx > tmp) {
                            existIdx = true;
                            tmp = idx;

                            length++;
                            if (length > maxLength) {
                                maxLength = length;
                            }

                            break;
                        }
                    }

                    if (!existIdx) {
                        break;
                    }
                }

            }
        }
        return maxLength;
    }


}




