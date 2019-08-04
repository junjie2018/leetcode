package T0399;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        [["a","b"],["b","c"]]
        [2.0,3.0]
        [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
         */
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));


        System.out.println(Arrays.toString(new Solution().calcEquation(equations, new double[]{
                2.0, 3.0
        }, queries)));
    }
}

class Solution {

    private HashMap<String, HashMap<String, Double>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        this.graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);

            HashMap<String, Double> tmp;
            if (!graph.containsKey(A)) {
                tmp = new HashMap<>();
                graph.put(A, tmp);
            } else {
                tmp = graph.get(A);
            }
            tmp.put(B, values[i]);


            if (!graph.containsKey(B)) {
                tmp = new HashMap<>();
                graph.put(B, tmp);
            } else {
                tmp = graph.get(B);
            }
            tmp.put(A, 1 / values[i]);
        }

        int idx = 0;
        double[] result = new double[queries.size()];

        for (List<String> query : queries) {
            String A = query.get(0);
            String B = query.get(1);

            if (graph.containsKey(A) && graph.containsKey(B)) {
                HashSet<String> flags = new HashSet<>();
                result[idx++] = dfs(A, B, flags, 1.0);
            } else {
                result[idx++] = -1.0;
            }
        }

        return result;
    }

    private double dfs(String curString, String tarString, HashSet<String> flags, double value) {
        if (curString.equals(tarString)) {
            return value;
        }
        if (flags.contains(curString)) {
            return -1.0;
        }

        flags.add(curString);

        HashMap<String, Double> map = graph.get(curString);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            double result = dfs(entry.getKey(), tarString, flags, value * entry.getValue());
            if (result != -1.0) {
                return result;
            }
        }
        return -1.0;
    }
}
