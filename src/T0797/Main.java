package T0797;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {

    private int[][] graph;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.graph = graph;

        dfs(new ArrayList<>(), new int[graph.length], 0);

        return result;
    }

    private void dfs(ArrayList<Integer> integers, int[] flags, int node) {
        if (node == graph.length - 1) {
            integers.add(node);
            result.add(integers);
            return;
        }
        if (flags[node] == -1) {
            return;
        }

        flags[node] = -1;
        integers.add(node);
        for (int i = 0; i < graph[node].length; i++) {
            dfs(new ArrayList<>(integers), Arrays.copyOf(flags, flags.length), graph[node][i]);
        }
    }
}
