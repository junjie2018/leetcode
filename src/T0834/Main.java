package T0834;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution4().sumOfDistancesInTree(6, new int[][]{
                {0, 1},
                {0, 2},
                {2, 3},
                {2, 4},
                {2, 5}
                //                {2, 1},
                //                {0, 2}
        })));
    }
}

/**
 * 为了省一点空间，写的我头皮发麻
 */
@SuppressWarnings("all")
class Solution {

    public int[] sumOfDistancesInTree(int N, int[][] edges) {

        if (N == 1) return new int[1];

        int[] parentSet = new int[N];
        int[] result = new int[N];


        // 构建tree
        for (int[] edge : edges) {
            if (!tree.containsKey(edge[0])) {
                tree.put(edge[0], new HashSet<>());
            }
            tree.get(edge[0]).add(edge[1]);
        }

        // 构建并交集


        getMap(0);

        for (int i = 0; i < N; i++) {
            int sum = 0;
            boolean iIsParentNode = tree.containsKey(i);

            // i是一个叶子节点
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (iIsParentNode) {
                    if (map.get(i).containsKey(j)) {
                        sum += map.get(i).get(j);
                        continue;
                    }
                }

                int parentOfI = i;
                while (!map.get(parentSet[parentOfI]).containsKey(j)) {
                    parentOfI = parentSet[parentOfI];
                }
                sum += map.get(parentSet[parentOfI]).get(i) + map.get(parentSet[parentOfI]).get(j);

            }
            result[i] = sum;
        }

        return result;
    }

    HashMap<Integer, HashSet<Integer>> tree = new HashMap<>();
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

    private void getMap(int curNode) {

        HashMap<Integer, Integer> nodeToNodeLength = new HashMap<>();
        nodeToNodeLength.put(curNode, 0);

        HashSet<Integer> set = tree.get(curNode);
        for (Integer node : set) {
            // 证明node为一个父节点
            if (tree.containsKey(node)) {
                getMap(node);
                for (Map.Entry<Integer, Integer> entry : map.get(node).entrySet()) {
                    nodeToNodeLength.put(entry.getKey(), entry.getValue() + 1);
                }
            }
            // 无论node是不是叶子节点，都需要如下操作
            nodeToNodeLength.put(node, 1);

        }
        map.put(curNode, nodeToNodeLength);
    }
}

@SuppressWarnings("all")
class Solution2 {

    private int[] parentSet;
    private boolean[] flag;
    private HashMap<Integer, HashSet<Integer>> tree = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();


    public int[] sumOfDistancesInTree(int N, int[][] edges) {

        if (N == 1)
            return new int[1];

        // 构建tree
        for (int[] edge : edges) {
            int left = edge[0], right = edge[1];
            if (!tree.containsKey(left)) {
                tree.put(left, new HashSet<>());
            }

            if (!tree.containsKey(right)) {
                tree.put(right, new HashSet<>());
            }

            tree.get(right).add(left);
            tree.get(left).add(right);
        }

        // 构建并交集 和 查询使用的Map
        parentSet = new int[N];
        flag = new boolean[N];
        getParentSetAndMap(0);

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {

            boolean iIsParentNode = map.containsKey(i);

            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;

                if (iIsParentNode) {
                    if (map.get(i).containsKey(j)) {
                        sum += map.get(i).get(j);
                        continue;
                    }
                }

                int parentOfI = i;
                while (!map.get(parentSet[parentOfI]).containsKey(j)) {
                    parentOfI = parentSet[parentOfI];
                }
                sum += map.get(parentSet[parentOfI]).get(i) + map.get(parentSet[parentOfI]).get(j);

            }
            result[i] = sum;
        }

        return result;
    }

    private void getParentSetAndMap(int curNode) {
        flag[curNode] = true;
        HashMap<Integer, Integer> lengthMap = new HashMap<>();
        HashSet<Integer> toNodes = tree.get(curNode);
        for (Integer node : toNodes) {
            if (!flag[node]) {
                if (tree.get(node).size() != 1) {
                    getParentSetAndMap(node);
                    for (Map.Entry<Integer, Integer> entry : map.get(node).entrySet()) {
                        lengthMap.put(entry.getKey(), entry.getValue() + 1);
                    }
                }

                lengthMap.put(node, 1);
                parentSet[node] = curNode; // 并交集构建
            }
        }

        lengthMap.put(curNode, 0); //便于后面部分编码
        map.put(curNode, lengthMap);
    }
}

/*
    这个方案仅提供思路了，我在纸上已经跑通了，但是是立方级别的，我不是太满意

   1.对于一条边的两个结点A和结点B，在graph中先对B结点进行bfs，在bfs的同时：
        a.记录层数，
        b.记录每层元素的个数
   2.计算：右边元素总数 = 层数 * 该层元素数
   3.再对结点A进行bfs，在bfs的同时：
        a.记录层数，
        b.记录每层元素个数
        c.为每个元素的值加上：层数 + 右边元素总数
   4.计算：左边元素总数 = 层数 * 该层元素数
   4.在对结点B进行bfs，在bfs的同时
        a.为每个元素的值加上：层数 + 右边元素总数

   这个方案理论上还没有我第一个方案好，但是我第一个方案在创建空间时浪费了大量时间
 */
class Solution3 {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {

        return null;
    }
}

class Solution4 {
    private int[] count, ans;
    private List<Set<Integer>> tree;
    private int N;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (edges.length < 1) return new int[N];

        this.N = N;
        this.count = new int[N];
        this.ans = new int[N];
        this.tree = new ArrayList<>();

        Arrays.fill(count, 1);

        IntStream.range(0, N).forEach(item -> tree.add(new HashSet<>()));

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs1(0, -1);
        dfs2(0, -1);

        return ans;
    }

    private void dfs1(int cur, int parent) {
        for (int child : tree.get(cur)) {
            if (child != parent) {
                dfs1(child, cur);
                count[cur] += count[child];
                ans[cur] += ans[child] + count[child];
            }
        }
    }

    private void dfs2(int cur, int parent) {
        for (int child : tree.get(cur)) {
            if (child != parent) {
                ans[child] = ans[cur] + (N - count[child] - count[child]);
                dfs2(child, cur);
            }
        }
    }
}