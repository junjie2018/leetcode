package T0076;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().minWindow("bba", "ab"));
//        System.out.println(new Solution3().minWindow("a", "aa"));
        System.out.println(new Solution3().minWindow("ADOBECODEBANC", "ABC"));
    }
}

class Solution {

    private static final int SIZE = 131072;
    private static final int CHAR_SIZE = 256;

    public String minWindow(String s, String t) {
        int[] amount = new int[CHAR_SIZE];
        for (int i = 0; i < t.length(); i++) {
            amount[t.charAt(i)]++;
        }

        boolean isMatched = false;
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int minLeft = 0, minRight = 0;
        int[] curAmount = new int[CHAR_SIZE];
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (amount[rightChar] == 0) {
                right++;
                continue;
            }

            curAmount[rightChar]++;
            while (isMatch(amount, curAmount)) {

                char leftChar = s.charAt(left);
                if (amount[leftChar] == 0) {
                    left++;
                    continue;
                }

                if (right - left < minLen) {
                    minLeft = left;
                    minRight = right;
                    minLen = right - left;
                    isMatched = true;
                }

                curAmount[leftChar]--;
                left++;
            }

            right++;
        }
        return isMatched ? s.substring(minLeft, minRight + 1) : "";
    }

    private boolean isMatch(int[] amount, int[] curAmount) {
        for (int i = 0; i < CHAR_SIZE; i++) {
            if (curAmount[i] < amount[i]) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {

    private static final int SIZE = 131072;
    private static final int CHAR_SIZE = 256;

    public String minWindow(String s, String t) {
        int[] amount = new int[CHAR_SIZE];
        int[] position = new int[SIZE];
        char[] chars = new char[SIZE];

        for (int i = 0; i < t.length(); i++) {
            amount[t.charAt(i)]++;
        }

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (amount[s.charAt(i)] != 0) {
                chars[index] = s.charAt(i);
                position[index] = i;
                index++;
            }
        }

        String result = "";
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int[] curAmount = new int[CHAR_SIZE];
        while (right < index) {
            char rightChar = chars[right];
            curAmount[rightChar]++;

            while (isMatch(amount, curAmount)) {
                if (position[right] - position[left] < minLen) {
                    minLen = position[right] - position[left];
                    result = s.substring(position[left], position[right] + 1);
                }


                char leftChar = chars[left];
                curAmount[leftChar]--;
                left++;
            }

            right++;
        }
        return result;
    }

    private boolean isMatch(int[] amount, int[] curAmount) {
        for (int i = 0; i < CHAR_SIZE; i++) {
            if (curAmount[i] < amount[i]) {
                return false;
            }
        }
        return true;
    }
}

class Solution3 {

    private static final int CHAR_SIZE = 256;

    public String minWindow(String s, String t) {
        int count = t.length();
        int[] amount = new int[CHAR_SIZE];
        for (int i = 0; i < t.length(); i++) {
            amount[t.charAt(i)]++;
        }

        int curCount = 0;
        int minLen = Integer.MAX_VALUE;
        boolean isMatched = false;
        int left = 0, right = 0;
        int minLeft = 0, minRight = 0;
        int[] curAmount = new int[CHAR_SIZE];
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (amount[rightChar] == 0) {
                right++;
                continue;
            }

            if (curAmount[rightChar] < amount[rightChar]) {
                curCount++;
            }
            curAmount[rightChar]++;

            while (curCount >= count) {
                char leftChar = s.charAt(left);
                if (amount[leftChar] == 0) {
                    left++;
                    continue;
                }

                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                    minRight = right;
                    isMatched = true;
                }


                if (curAmount[leftChar] <= amount[leftChar]) {
                    curCount--;
                }

                curAmount[leftChar]--;
                left++;
            }
            right++;
        }

        return isMatched ? s.substring(minLeft, minRight + 1) : "";
    }
}
