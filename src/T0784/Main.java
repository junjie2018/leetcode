package T0784;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
    }
}

class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        letterCasePermutationCore(S.toCharArray(), 0);
        return res;
    }

    private void letterCasePermutationCore(char[] arr, int idx) {
        if (idx >= arr.length) {
            res.add(String.valueOf(arr));
            return;
        }

        while (idx < arr.length) {
            if ((arr[idx] < 'a' || arr[idx] > 'z') &&
                    (arr[idx] < 'A' || arr[idx] > 'Z')) {
                idx++;
                continue;
            }
            letterCasePermutationCore(arr, idx + 1);
            char[] tmp = Arrays.copyOf(arr, arr.length);
            if (tmp[idx] >= 'a' && tmp[idx] <= 'z') {
                tmp[idx] = (char) (tmp[idx] - 'a' + 'A');
            } else {
                tmp[idx] = (char) (tmp[idx] - 'A' + 'a');
            }
            letterCasePermutationCore(tmp, idx + 1);
            return;
        }
        res.add(String.valueOf(arr));
    }
}