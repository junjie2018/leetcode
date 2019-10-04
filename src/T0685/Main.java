package T0685;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(
//                new Solution().findRedundantDirectedConnection(CommonUtils.createInt2a("[[2,1],[3,1],[4,2],[1,4]]"))
                new Solution().findRedundantDirectedConnection(CommonUtils.createInt2a("[[1,2], [2,3], [3,4], [4,1], [1,5]]"))
//                new Solution().findRedundantDirectedConnection(CommonUtils.createInt2a("[[1,2],[1,3],[2,3]]"))
        );
    }
}

/**
 * 构成的图中必形成有向环：
 * 1.如果环中存在入度为2的结点，则删除该结点上在环中的入度
 * 2.如果环中不存在入度为2的结点，则删除该环最后一条边
 */
@SuppressWarnings("all")
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {

        int N = edges.length;

        int[] parentSet = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parentSet[i] = i;
        }


        int[] res = new int[2];
        boolean existTowDegree = false;
        int twoDegreePoint = 0;
        int firstParent = 0, secondParent = 0;
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];

            if (existTowDegree) {
                parentSet[to] = from;
            } else {
                int parentFrom = getParent(parentSet, from);
                if (parentFrom == to) res = new int[]{from, to};
                if (parentSet[to] != to) {
                    firstParent = parentSet[to];
                    secondParent = from;
                    twoDegreePoint = to;
                    existTowDegree = true;
                    parentSet[to] = -1;
                } else {
                    parentSet[to] = from;
                }
            }
        }

        if (existTowDegree) {
            if (getParent(parentSet, secondParent) == -1) return new int[]{secondParent, twoDegreePoint};
            if (getParent(parentSet, firstParent) == -1) return new int[]{firstParent, twoDegreePoint};
            return new int[]{secondParent, twoDegreePoint};
        } else {
            return res;
        }
    }

    private int getParent(int[] parentSet, int vertex) {
        int tmp = vertex;
        while (parentSet[tmp] != tmp) {
            tmp = parentSet[tmp];
            if (tmp < 0) return tmp;
            if (tmp == vertex) return tmp;
        }
        return tmp;
    }
}