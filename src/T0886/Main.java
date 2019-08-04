package T0886;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution3().possibleBipartition(10, new int[][]{
                //[[1,2],[2,3],[3,4],[4,5],[1,5]]
//                {1, 2},
//                {2, 3},
//                {3, 4},
//                {4, 5},
//                {1, 5},
                //[[1,2],[1,3],[2,4]]
//                {1, 2},
//                {1, 3},
//                {2, 4}
                //[[1,2],[3,4],[4,5],[3,5]]
//                {1, 2},
//                {3, 4},
//                {4, 5},
//                {3, 5},

                {4, 7},
                {4, 8},
                {5, 6},
                {1, 6},
                {3, 7},
                {2, 5},
                {5, 8},
                {1, 2},
                {4, 9},
                {6, 10},
                {8, 10},
                {3, 6},
                {2, 10},
                {9, 10},
                {3, 9},
                {2, 3},
                {1, 9},
                {4, 6},
                {5, 7},
                {3, 8},
                {1, 8},
                {1, 7},
                {2, 4},
        }));
    }
}

/**
 * 回溯法超出了时间限制
 */
class Solution {
    private int len;
    private int[][] dislikes;

    public boolean possibleBipartition(int N, int[][] dislikes) {

        if (dislikes == null || dislikes.length == 0) {
            return true;
        }

        this.len = dislikes.length;
        this.dislikes = dislikes;

        int[] parents = new int[N];
        parents[dislikes[0][0] - 1] = 1;
        parents[dislikes[0][1] - 1] = -1;

        return possibleBipartitionCore(1, parents);
    }

    private boolean possibleBipartitionCore(int idx, int[] parents) {

        if (idx >= len) {
            return true;
        }

        int[] curDislike = dislikes[idx];

        int fir = parents[curDislike[0] - 1];
        int sec = parents[curDislike[1] - 1];

        switch (fir) {
            case 0:
                switch (sec) {
                    case 0:
                        int[] parentsBck = Arrays.copyOf(parents, parents.length);

                        parents[curDislike[0] - 1] = 1;
                        parents[curDislike[1] - 1] = -1;

                        parentsBck[curDislike[0] - 1] = -1;
                        parentsBck[curDislike[1] - 1] = 1;

                        if (possibleBipartitionCore(idx + 1, parents)) return true;
                        if (possibleBipartitionCore(idx + 1, parentsBck)) return true;
                        break;
                    case 1:
                        parents[curDislike[0] - 1] = -1;
                        return possibleBipartitionCore(idx + 1, parents);
                    case -1:
                        parents[curDislike[0] - 1] = 1;
                        return possibleBipartitionCore(idx + 1, parents);
                }
            case 1:
                switch (sec) {
                    case 0:
                        parents[curDislike[1] - 1] = -1;
                        return possibleBipartitionCore(idx + 1, parents);
                    case 1:
                        return false;
                    case -1:
                        return possibleBipartitionCore(idx + 1, parents);
                }
            case -1:
                switch (sec) {
                    case 0:
                        parents[curDislike[1] - 1] = 1;
                        return possibleBipartitionCore(idx + 1, parents);
                    case 1:
                        return possibleBipartitionCore(idx + 1, parents);
                    case -1:
                        return false;
                }
        }
        return false;
    }
}

/**
 * 使用DFS解法，时间依然很长
 */
class Solution2 {
    private int N;
    private int[] flags;
    private HashMap<Integer, List<Integer>> graph;

    public boolean possibleBipartition(int N, int[][] dislikes) {


        int len = dislikes.length;

        this.N = N;
        this.graph = new HashMap<>();


        for (int i = 0; i < len; i++) {
            int key = Math.min(dislikes[i][0], dislikes[i][1]);
            int value = Math.max(dislikes[i][0], dislikes[i][1]);
            List<Integer> nodes = graph.computeIfAbsent(key, ArrayList::new);
            nodes.add(value);
        }


        for (int i = 1; i <= N; i++) {
            if (graph.containsKey(i)) {
                this.flags = new int[N + 1];
                flags[i] = 1;
                if (!dfs(graph.get(i), flags[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(List<Integer> nodes, int preFlag) {
        if (nodes == null) {
            return true;
        }

        for (Integer node : nodes) {
            if (flags[node] == 0) {
                flags[node] = -preFlag;
                if (!dfs(graph.get(node), flags[node])) {
                    return false;
                }
                continue;
            }
            if (flags[node] == preFlag) {
                return false;
            }
        }

        return true;
    }
}

/**
 * 使用并交集解题（暂时没有想法）
 */
class Solution3 {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] parents = new int[N + 1];
        int[] size = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
            size[i] = 1;
        }

        for (int[] dislike : dislikes) {
            int left = Math.min(dislike[0], dislike[1]);
            int right = Math.max(dislike[0], dislike[1]);

            int leftParent = getParent(parents, left);
            int rightParent = getParent(parents, right);

            if (leftParent == rightParent) {
                if ((size[leftParent] + size[rightParent]) % 2 == 0) {
                    return false;
                }
            }

            parents[rightParent] = leftParent;
            size[leftParent] += size[rightParent];
        }
        return true;
    }

    private int getParent(int[] parents, int idx) {
        while (parents[idx] != idx) {
            idx = parents[idx];
        }
        return idx;
    }
}

