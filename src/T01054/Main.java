package T01054;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().rearrangeBarcodes(new int[]{
//                1, 1, 1, 2, 2, 2
//                1, 1, 2
                1, 2, 2, 3
        })));
    }
}

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());

        int pivot = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = list.get(i).getValue();
            int value = list.get(i).getKey();
            Arrays.fill(barcodes, pivot, pivot + count, value);
            pivot = pivot + count;
        }

        int[] result = new int[barcodes.length];

        int idx = 0;
        int s1 = 0;
        int s2 = barcodes.length % 2 == 0 ? barcodes.length / 2 : barcodes.length / 2 + 1;
        for (int i = 0; i < barcodes.length / 2; i++) {
            result[idx++] = barcodes[s1 + i];
            result[idx++] = barcodes[s2 + i];
        }
        if (barcodes.length % 2 == 1) {
            result[idx] = barcodes[barcodes.length / 2];
        }


        return result;

    }
}
