package T0684;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int N = edges.length;

        int[] parentSet = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parentSet[i] = i;
        }


        for (int[] edge : edges) {
            int leftParent = getParent(parentSet, edge[0]);
            int rightParent = getParent(parentSet, edge[1]);
            if (leftParent == rightParent) {
                return edge;
            } else {
                parentSet[rightParent] = leftParent;
            }
        }

        return null;
    }

    private int getParent(int[] parentSet, int vertex) {
        while (parentSet[vertex] != vertex) {
            vertex = parentSet[vertex];
        }
        return vertex;
    }
}