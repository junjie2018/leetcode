package T0928;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minMalwareSpread(new int[][]{
                // [[1,1,0],[1,1,0],[0,0,1]]
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1},
                // [[1,1,1,0],[1,1,0,0],[1,0,1,0],[0,0,0,1]]
//                {1, 1, 1, 0},
//                {1, 1, 0, 0},
//                {1, 0, 1, 0},
//                {0, 0, 0, 1}
                // [[1,1,0,0],[1,1,0,1],[0,0,1,0],[0,1,0,1]]
//                {1, 1, 0, 0},
//                {1, 1, 0, 1},
//                {0, 0, 1, 0},
//                {0, 1, 0, 1}
        }, new int[]{
                0, 1
        }));
    }
}

class Solution {

    private int[][] graph;
    private int[] initial;

    public int minMalwareSpread(int[][] graph, int[] initial) {

        if (graph == null || graph.length == 0) {
            return 0;
        }

        this.graph = graph;
        this.initial = initial;

        Arrays.sort(initial);

        int[] flags = new int[graph.length];
        for (int i = 0; i < initial.length; i++) {
            flags[initial[i]] = -1;
        }

        int maxSum = 0, maxNode = initial[0];
        for (int i = 0; i < initial.length; i++) {
            int maxI = 0;
            flags[initial[i]] = 1;
            for (int j = 0; j < graph.length; j++) {
                if (j != i && graph[initial[i]][j] == 1) {
                    maxI = Math.max(maxI, dfs(j, flags));
                }
            }
            flags[initial[i]] = -1;

            if (maxI > maxSum) {
                maxSum = maxI;
                maxNode = initial[i];
            }
        }
        return maxNode;
    }

    private int dfs(int n, int[] flags) {
        if (flags[n] == -1) {
            return -1;
        }
        if (flags[n] == 1) {
            return 0;
        }

        flags[n] = 1;

        int sum = 1;
        for (int i = 0; i < graph.length; i++) {
            if (i != n && graph[n][i] == 1) {
                int sumI = dfs(i, flags);
                if (sumI == -1) {
                    flags[n] = -1;
                    return -1;
                }
                sum += sumI;
            }
        }
        return sum;
    }
}

