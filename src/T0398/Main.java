package T0398;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new Solution(CommonUtils.create("[1,2,3,3,3]")).pick(3);
    }
}

class Solution {

    Map<Integer, Index> indexMap;

    public Solution(int[] nums) {
        this.indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], Index::new).put(i);

        }
    }

    public int pick(int target) {
        return indexMap.get(target).get();
    }

    static class Index {
        int idx;
        List<Integer> indexes;

        public Index() {
            this.idx = 0;
            this.indexes = new ArrayList<>();
        }

        public Index(Integer integer) {
            this.idx = 0;
            this.indexes = new ArrayList<>();
        }

        void put(int index) {
            indexes.add(index);
        }

        int get() {
            return indexes.get(idx++ % indexes.size());
        }
    }
}