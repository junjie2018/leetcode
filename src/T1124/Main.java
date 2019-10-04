package T1124;

import Common.CommonUtils;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestWPI(CommonUtils.createInt1a("[9,9,6,0,6,6,9]")));
//        System.out.println(new Solution().longestWPI(CommonUtils.createInt1a("[6,6,6]")));
    }
}

class Solution {
    public int longestWPI(int[] hours) {
        int len = hours.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) res = i + 1;
            else {
                map.putIfAbsent(sum, i);
                if (map.containsKey(sum - 1)) res = Math.max(res, i - map.get(sum - 1));
            }
        }

        return res;
    }
}
