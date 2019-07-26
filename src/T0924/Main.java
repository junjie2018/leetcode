package T0924;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minMalwareSpread(new int[][]{
//                {1, 1, 1},
//                {1, 1, 1},
//                {1, 1, 1}
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
//                {1, 0, 0},
//                {0, 1, 0},
//                {0, 0, 1}
//                {1, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 1, 0},
//                {0, 0, 0, 1, 1, 0},
//                {0, 0, 0, 0, 0, 1},
        }, new int[]{
                1, 3
        }));
    }
}

class Solution {

    private int[] disjoint;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;

        this.disjoint = new int[n];
        int[] counts = new int[n];

        for (int i = 0; i < n; i++) {
            disjoint[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int parentI = getParent(i);
                if (graph[i][j] == 1) {
                    int parentJ = getParent(j);
                    if (parentI < parentJ) {
                        disjoint[parentJ] = parentI;
                    } else if (parentI > parentJ) {
                        disjoint[parentI] = parentJ;
                    }
                }
            }
        }

        // 计算每个区域的元素个数
        for (int i = 0; i < n; i++) {
            counts[getParent(i)]++;
        }

        Arrays.sort(initial);

        // 计算每个initial中元素的父结点个数
        int[] initialCounts = new int[n];
        for (int i = 0; i < initial.length; i++) {
            initialCounts[getParent(initial[i])]++;
        }

        int maxValue = initial[0];
        for (int i = 1; i < initial.length; i++) {
            if (initialCounts[getParent(initial[i])] == 1) {
                if (counts[getParent(initial[i])] > counts[getParent(maxValue)]) {
                    maxValue = initial[i];
                }
            }
        }

        return maxValue;
    }

    private int getParent(int i) {
        while (disjoint[i] != i) {
            i = disjoint[i];
        }
        return i;
    }
}

class Solution2 {

    private static class Disjoint {
        int n;
        int[] counts;
        int[] parents;

        public Disjoint(int n) {
            this.n = n;
            this.counts = new int[n];
            this.parents = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        private void union(int i, int j) {
            int parentI = getParent(i), parentJ = getParent(j);
            if (parentI < parentJ) {
                parents[parentJ] = parentI;
            } else if (parentI > parentJ) {
                parents[parentI] = parentJ;
            }
        }

        private void updateCounts() {
            for (int i = 0; i < n; i++) {
                counts[getParent(i)]++;
            }
        }

        private int getParent(int i) {
            while (parents[i] != i) {
                i = parents[i];
            }
            return i;
        }

        private int getCount(int i) {
            return counts[getParent(i)];
        }
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {

        int n = graph.length;

        Disjoint disjoint = new Disjoint(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    disjoint.union(i, j);
                }
            }
        }

        disjoint.updateCounts();

        Arrays.sort(initial);

        int[] counts = new int[n];
        for (int i = 0; i < initial.length; i++) {
            counts[disjoint.getParent(initial[i])]++;
        }

        int maxIdx = 0;
        for (int i = 0; i < initial.length; i++) {
            if (counts[disjoint.getParent(initial[i])] == 1) {
                if (disjoint.getCount(initial[i]) > disjoint.getCount(initial[maxIdx])) {
                    maxIdx = i;
                }
            } else {
                if (1 > disjoint.getCount(initial[maxIdx])) {
                    maxIdx = i;
                }
            }
        }

        return initial[maxIdx];
    }
}
