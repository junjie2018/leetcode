package T0014;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{

                "flower", "flow", "flight"
        }));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            char aChar;
            if (i < strs[0].length()) {
                aChar = strs[0].charAt(i);
            } else {
                return sb.toString();
            }

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != aChar) {
                    return sb.toString();
                }
            }
            sb.append(aChar);
        }

        return sb.toString();
    }
}