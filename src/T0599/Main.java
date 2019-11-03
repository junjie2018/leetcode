package T0599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int cur = map.get(list2[i]) + i;
                if (cur < min) {
                    min = cur;
                    if (result.size() > 0) result.clear();
                    result.add(list2[i]);
                } else if (cur == min) {
                    result.add(list2[i]);
                }
            }
        }

        String[] res = new String[result.size()];
        result.toArray(res);
        return res;
    }
}