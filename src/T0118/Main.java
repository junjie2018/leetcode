package T0118;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().generate(5).toString());
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();

            if (i == 1) {
                list.add(1);
                result.add(list);
                continue;
            }

            list.add(1);
            List<Integer> preList = result.get(result.size() - 1);
            for (int j = 0; j < preList.size() - 1; j++) {
                list.add(preList.get(j) + preList.get(j + 1));
            }
            list.add(1);

            result.add(list);
        }

        return result;
    }
}
