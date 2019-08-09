package T0839;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numSimilarGroups(new String[]{
                "tars", "rats", "arts", "star"
        }));
    }
}

/**
 * 使用并查集结题
 */
class Solution {
    public int numSimilarGroups(String[] A) {
        int[] parents = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                String a = A[i];
                String b = A[j];
                if (isSimilar(a, b)) {
                    parents[findParent(parents, j)] = findParent(parents, i);
                }
            }
        }

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < parents.length; i++) {
            set.add(A[findParent(parents, i)]);
        }

        return set.size();
    }

    private int findParent(int[] parents, int i) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return i;
    }

    private boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 2;
    }
}