package T1104;

import Common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().pathInZigZagTree(26));
    }
}

// 解法是错误的，忽略的label在偶数层的问题
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> collections = new ArrayList<>();
        while (label != 1) {
            collections.add(label);
            label = label / 2;
        }
        collections.add(label);

        List<Integer> result = new ArrayList<>();
        int count = 1;
        for (int i = collections.size() - 1; i >= 0; i--) {
            if (count % 2 == 0) {
                int left = 1 << (count - 1);
                int right = (1 << count) - 1;

                result.add(right - (collections.get(i) - left));
            } else {
                result.add(collections.get(i));
            }
            count++;
        }


        return result;
    }
}

class Solution2 {
    public List<Integer> pathInZigZagTree(int label) {
        int layer = 1;
        int start = 1, end = 1;
        while (label < start || label > end) {
            layer++;
            start = 1 << (layer - 1);
            end = (1 << layer) - 1;
        }

        List<Integer> result = new ArrayList<>();
        result.add(label);

        if (layer % 2 == 0) {
            label = end - (label - start);
        }

        while (label != 1) {
            label /= 2;
            layer--;
            if (layer % 2 == 0) {
                start = 1 << (layer - 1);
                end = (1 << layer) - 1;
                result.add(end - (label - start));
            } else {
                result.add(label);
            }
        }

        Collections.reverse(result);

        return result;
    }
}