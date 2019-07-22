package T0028;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().kmpNext("ABCDABC")));
        System.out.println(new Solution2().strStr("aabaaabaaac", "aabaaac"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int[] next = kmpNext(needle);

        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                if (j > 0) {
                    j = next[j - 1];
                } else {
                    i++;
                    j = 0;
                }
            }
        }

        System.out.println(j);
        return -1;
    }

    public int[] kmpNext(String needle) {
        int[] next = new int[needle.length()];

        for (int i = 1, j = 0; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }
}

class Solution2 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int index = 0;
        while (index <= haystack.length() - needle.length()) {
            int i = index, j = 0;
            while (j<needle.length()){
                if(haystack.charAt(i)==needle.charAt(j)){
                    i++;j++;
                    if(j==needle.length()){
                        return i-j;
                    }
                }else {
                    break;
                }
            }
            index++;
        }
        return -1;
    }
}

class Solution3 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        return haystack.indexOf(needle);
    }
}



