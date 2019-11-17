package T0744;

import Common.CommonUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreatestLetter(
                new char[]{'c', 'f', 'j'},
//                new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'},
                'a'
        ));
    }
}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int slow = 0, fast = 1;
        while (fast < letters.length) {
            if (letters[fast] == letters[slow]) {
                ++fast;
                continue;
            }
            letters[++slow] = letters[fast++];
        }

        int res = Arrays.binarySearch(letters, 0, slow + 1, target);

        if (res < 0) {
            int insertPoint = -res - 1;
//            return insertPoint == letters.length ? letters[0] : letters[insertPoint];
            return insertPoint == slow + 1 ? letters[0] : letters[insertPoint];
        } else {
//            return res + 1 == letters.length ? letters[0] : letters[res + 1];
            return res + 1 == slow + 1 ? letters[0] : letters[res + 1];
        }
    }
}
