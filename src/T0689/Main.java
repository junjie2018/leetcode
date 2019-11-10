package T0689;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().repeatedStringMatch("aa", "a"));
        System.out.println(new Solution().repeatedStringMatch("bb", "bbbbbbb"));
    }
}

class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A.length() > B.length()) {
            String AA = repeatStr(A, 2);
            return A.contains(B) ? 1 : AA.contains(B) ? 2 : -1;
        } else {
            int n = B.length() / A.length() + 2;
            String AA = repeatStr(A, n);
            int res = AA.indexOf(B);
            if (res >= 0) {
                if (res == 0) {
                    int tmp = B.length() / A.length();
                    return B.length() % A.length() == 0 ? tmp : tmp + 1;
                } else {
                    int tmp = (res + B.length()) / A.length();
                    return (res + B.length()) % A.length() == 0 ? tmp : tmp + 1;
                }

            } else {
                return -1;
            }
        }
    }

    private String repeatStr(String source, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(source);
        }
        return sb.toString();
    }
}
