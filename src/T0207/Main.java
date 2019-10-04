package T0207;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, CommonUtils.createInt2a("[[1,0]]")));
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        Map<Integer, Integer> degree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            degree.put(i, 0);
        }

        for (int[] prerequisite : prerequisites) {
            List<Integer> vertexes = graph.computeIfAbsent(prerequisite[0], ArrayList<Integer>::new);
            vertexes.add(prerequisite[1]);

            degree.put(prerequisite[1], degree.get(prerequisite[1]) + 1);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        degree.forEach((key, value) -> {
            if (value == 0) {
                queue.addFirst(key);
            }
        });


        while (queue.size() > 0) {
            int vertex = queue.removeLast();
            if (graph.containsKey(vertex)) {
                List<Integer> vertexes = graph.get(vertex);
                vertexes.forEach(v -> {
                    int d = degree.get(v);
                    if (d - 1 == 0) queue.addFirst(v);
                    else degree.put(v, d - 1);
                });

                graph.remove(vertex);
            }
        }

        return graph.size() <= 0;
    }
}
