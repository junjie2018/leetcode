package T1129;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Solution().shortestAlternatingPaths(3,
                new int[][]{
                        {0, 1},
                        {1, 2}
                }, new int[][]{
                });
//        System.out.println(0X0080);
//        System.out.println(0X0100);
    }
}

class Solution {

    private static final int INF = 401;

    private static final int RED = 0X0001;
    private static final int BLUE = 0X0002;


    private static final int INDEX = 0X007F;                // 得到index
    private static final int RED_IS_VISITED = 0X0080;       // 判断上一次是否被红色路径访问
    private static final int BLUE_IS_VISITED = 0X0100;      // 判断上意思是否被蓝色路径访问

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {

        // 构造图
        int[][] graph = new int[n][n];
        for (int[] red_edge : red_edges) {
            graph[red_edge[0]][red_edge[1]] |= RED;
        }
        for (int[] blue_edge : blue_edges) {
            graph[blue_edge[0]][blue_edge[1]] |= BLUE;
        }

        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            result[i] = INF;
        }

        int[] flags = new int[n];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (graph[0][i] != 0) {
                if ((graph[0][i] & RED) != 0) {
                    queue.addFirst(i | RED_IS_VISITED);
                }
                if ((graph[0][i] & BLUE) != 0) {
                    queue.addFirst(i | BLUE_IS_VISITED);
                }
                result[i] = Math.min(result[i], 1);
            }
        }
        flags[0] |= RED;
        flags[0] |= BLUE;

        int length = 2;
        while (queue.size() > 0) {
            Deque<Integer> tmp = new ArrayDeque<>();
            while (queue.size() > 0) {
                int element = queue.removeLast();
                int idx = element & INDEX;

                // 当前idx的红色从未被处理，且上次访问的是蓝色
                if ((flags[idx] & RED) == 0 && (element & BLUE_IS_VISITED) != 0) {
                    for (int i = 0; i < n; i++) {
                        if ((graph[idx][i] & RED) != 0) {
                            result[i] = Math.min(result[i], length);
                            tmp.addFirst(i | RED_IS_VISITED);
                        }
                    }
                    flags[idx] |= RED;
                }
                // 当前idx的蓝色从未被处理，且上次访问的是蓝色
                if ((flags[idx] & BLUE) == 0 && (element & RED_IS_VISITED) != 0) {
                    for (int i = 0; i < n; i++) {
                        if ((graph[idx][i] & BLUE) != 0) {
                            result[i] = Math.min(result[i], length);
                            tmp.addFirst(i | BLUE_IS_VISITED);
                        }
                    }
                    flags[idx] |= BLUE;
                }
            }
            length++;
            queue = tmp;
        }

        for (int i = 1; i < n; i++) {
            if (result[i] == INF) {
                result[i] = -1;
            }
        }

        return result;

    }
}
