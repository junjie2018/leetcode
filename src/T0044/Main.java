package T0044;

import Common.CommonUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().isMatch("abceb", "*a*b"));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {

        boolean[][] stat = new boolean[p.length() + 1][s.length() + 1];
        stat[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            stat[i + 1][0] = p.charAt(i) == '*' && stat[i][0];
            for (int j = 0; j < s.length(); j++) {

                int m = i + 1, n = j + 1;
                switch (p.charAt(i)) {
                    case '*':
                        stat[m][n] = stat[m - 1][n - 1] || stat[m - 1][n] || stat[m][n - 1];
                        break;
                    case '?':
                        stat[m][n] = stat[m - 1][n - 1];
                        break;
                    default:
                        stat[m][n] = p.charAt(i) == s.charAt(j) && stat[m - 1][n - 1];
                        break;
                }
            }
        }

//        CommonUtils.show(stat);
        return stat[p.length()][s.length()];
    }
}

class Solution2 {
    public boolean isMatch(String s, String p) {

        if (s.equals(p)) {
            return true;
        }

        if (p.length() == 0 || s.length() == 0) {
            return false;
        }

        String[] ps = p.split("\\*+");

        // 处理p字符串全部由*组成
        if (ps.length == 0) {
            return true;
        }

        // 处理p字符串首部不以*开头
        int index = 0;
        if (p.charAt(0) != '*') {
            if (ps[0].charAt(index) == s.charAt(index) || ps[0].charAt(index) == '?') {
                index++;
            } else {
                return false;
            }
        }

        // 处理p字符串尾部不以*结尾
        if (p.charAt(0) != '*') {
            if (ps[0].charAt(index) == s.charAt(index) || ps[0].charAt(index) == '?') {
                index++;
            } else {
                return false;
            }
        }

        // 核心逻辑
        int i = 1;
        while (i < ps.length) {
            if ((index = indexOf(p, ps[i], index)) == -1) {
                return false;
            }
            index += ps[i].length();
            i++;
        }

        return index >= s.length() || p.charAt(p.length() - 1) == '*';
    }

    private int indexOf(String origin, String target, int from) {
        int tmp = 0;
        int i = from, j = 0;
        while (i + tmp < origin.length() && j + tmp < target.length()) {
            if (origin.charAt(i + tmp) == target.charAt(j + tmp) || target.charAt(j + tmp) == '.') {
                tmp++;
            } else {
                i++;
                tmp = 0;
            }
        }
        return j + tmp >= target.length() ? i : -1;
    }
}
