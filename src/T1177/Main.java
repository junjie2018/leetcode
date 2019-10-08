package T1177;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().canMakePaliQueries(
                "abcda",
                CommonUtils.createInt2a("[[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]")
        ));
    }
}

// 29/31 心疼
class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int[] map = new int[26];
            int left = query[0], right = query[1];
            for (int i = left; i <= right; i++) {
                map[s.charAt(i) - 'a']++;
            }

            int count = 0;
            for (int i = 0; i < 26; i++) {
                map[i] = map[i] % 2;
                if (map[i] == 1) ++count;
            }
            int len = right - left + 1;
            if (len % 2 == 1) --count;

            if (count <= 2 * query[2]) result.add(true);
            else result.add(false);

        }

        return result;
    }
}

class Solution2 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        int[] counts = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            counts[i + 1] = counts[i] ^ (1 << (s.charAt(i) - 'a'));
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0], right = query[1];


            // 这儿可以优化成位运算
//            int count = 0;
//            String countStr = Integer.toBinaryString(counts[left] ^ counts[right + 1]);
//            for (int i = 0; i < countStr.length(); i++) {
//                if (countStr.charAt(i) == '1') ++count;
//            }
            int count = 0;
            int n = counts[left] ^ counts[right + 1];
            while (n > 0) {
                count++;
                n = n & (n - 1);
            }

            int len = right - left + 1;
            if (len % 2 == 1) --count;

            if (count <= 2 * query[2]) result.add(true);
            else result.add(false);

        }

        return result;
    }
}
