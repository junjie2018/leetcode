package T1079;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().numTilePossibilities("AAB"));
    }
}

/**
 * 解法问题很大，根本计算不出正确的结果
 */
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] map = new int[26];

        for (int i = 0; i < tiles.length(); i++) {
            map[tiles.charAt(i) - 'A']++;
        }

        int count = 0;

        int product = 1;
        for (int value : map) {
            if (value > 1) {
                product *= value;
                count++;
            }
        }


        for (int i = 1; i < tiles.length(); i++) {
            count += A(tiles.length(), i + 1);
        }

        return count / product;
    }

    // 这个地方还能优化，但是输入只有7个字符，感觉没有必要
    private int A(int n, int choose) {
        int sum = 1;
        for (int i = 0; i < choose; i++) {
            sum *= n - i;
        }
        return sum;
    }
}

class Solution2 {
    private int count = 0;

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            map.put(tiles.charAt(i), map.getOrDefault(tiles.charAt(i), 0) + 1);
        }

        numTilePossibilitiesCore(map);

        return count - 1;
    }

    private void numTilePossibilitiesCore(Map<Character, Integer> map) {
        map.forEach((key, value) -> {
            if (value != 0) {
                HashMap<Character, Integer> tmp = new HashMap<>(map);
                tmp.put(key, value - 1);
                numTilePossibilitiesCore(tmp);
            }
        });
        ++count;
    }
}