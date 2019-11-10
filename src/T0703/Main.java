package T0703;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, CommonUtils.createInt1a("[1,1]"));
        /*
            ["KthLargest","add","add","add","add","add"]
            [[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
         */
        kthLargest.add(1);
        kthLargest.add(1);
        kthLargest.add(3);
        kthLargest.add(3);
        kthLargest.add(3);
        kthLargest.add(4);
        kthLargest.add(4);
        kthLargest.add(4);
    }
}


class KthLargest {

    private int k;
    private List<Integer> list;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new ArrayList<>();

        for (int num : nums) {
            add(num);
        }

    }

    public int add(int val) {
        if (list.size() < k) {
            int insertPoint = Collections.binarySearch(list, val, Comparator.reverseOrder());
            insertPoint = insertPoint >= 0 ? insertPoint : -insertPoint - 1;
            list.add(insertPoint, val);
            return list.size() >= k ? list.get(list.size() - 1) : -1;
        }

        if (val < list.get(list.size() - 1)) {
            return list.get(list.size() - 1);
        }

        int insertPoint = Collections.binarySearch(list, val, Comparator.reverseOrder());
        insertPoint = insertPoint >= 0 ? insertPoint : -insertPoint - 1;
        list.add(insertPoint, val);

        list.remove(list.size() - 1);

        return list.get(list.size() - 1);
    }
}
