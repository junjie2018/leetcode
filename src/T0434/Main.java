package T0434;


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countSegments("Hello, my name is John"));
    }
}

class Solution {
    public int countSegments(String s) {
        s=s.trim();
        if (s.length() == 0) return 0;
        return s.split("\\s+").length;
    }
}

/*
    这道题很违背常识啊
 */
class Solution2 {
    public int countSegments(String s) {

        int count = 0;
        boolean hasOperation = false;
        boolean isBeginCount = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z')) {
                if (!isBeginCount) isBeginCount = true;
            } else if (ch == '\'' || ch == '-') {
                hasOperation = true;
            } else {
                if (isBeginCount) {
                    ++count;
                    isBeginCount = false;
                }
            }
        }

        if (isBeginCount) ++count;

        return count;
    }
}
