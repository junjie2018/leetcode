package T1122;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Tuple> map = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], new Tuple(arr2[i], i));
        }

        List<Tuple> result = new ArrayList<>();
        for (int num : arr1) {
            if (map.containsKey(num)) {
                result.add(map.get(num));
            } else {
                result.add(new Tuple(num, 1001));
            }
        }

        result.sort((a, b) -> {
            if (a.idx == b.idx) return Integer.compare(a.val, b.val);
            return Integer.compare(a.idx, b.idx);
        });

        int[] res = new int[arr1.length];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i).val;
        }

        return res;
    }

    static class Tuple {
        int val;
        int idx;

        public Tuple(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}

// 桶排序的一种解决思路
class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int len = arr1.length;

        int[] bucket = new int[1001];
        for (int i = 0; i < len; i++) {
            bucket[arr1[i]]++;
        }

        int idx = 0;
        int[] res = new int[len];

        // 处理arr2中包含的元素
        for (int i = 0; i < arr2.length; i++) {
            while (bucket[arr2[i]]-- > 0) {
                res[idx++] = arr2[i];
            }
        }

        // 处理arr2中未包含的元素
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                res[idx++] = i;
            }
        }
        return res;

    }
}
