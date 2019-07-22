package T0005;

import com.sun.deploy.util.StringUtils;

import javax.xml.stream.events.Characters;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("babad"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();

        boolean[][] stat = new boolean[len][len];

        String result = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            stat[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            stat[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (stat[i][i + 1]) {
                result = s.substring(i, i + 1 + 1);
            }
        }

        // n表示当前处理的字串的长度
        for (int n = 2; n < len; n++) {
            for (int i = 0; i < len - n; i++) {
                if (s.charAt(i) == s.charAt(i + n)) {
                    stat[i][i + n] = stat[i + 1][i + n - 1];
                    if (stat[i][i + n]) {
                        result = s.substring(i, i + n + 1);
                    }
                }
            }
        }


//        int j = 0;
//        System.out.printf("%2c", '-');
//        for (int i = 0; i < s.length(); i++) {
//            System.out.printf("%2c", Character.toUpperCase(s.charAt(i)));
//        }
//        System.out.println();
//        for (boolean[] inner : stat) {
//            System.out.printf("%2c", Character.toUpperCase(s.charAt(j++)));
//            for (boolean result : inner) {
//                char c = result ? 'T' : 'F';
//                System.out.printf("%2c", c);
//            }
//            System.out.println();
//        }
        return result;
    }
}

class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLength = 0,maxLeft = 0, maxRight = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以自身为中心点进行扩散
            longestPalindromeCore(s,i,i);
            if(length > maxLength){
                maxLength = length; maxLeft = left; maxRight = right;
            }

            if (i + 1 < s.length()) {
                // 以自身与下一个节点的中间线为中心点进行扩散
                longestPalindromeCore(s,i,i+1);
                if(length > maxLength){
                    maxLength = length; maxLeft = left; maxRight = right;
                }
            }

        }

        return s.substring(maxLeft, maxRight);
    }
    private int left,right,length;
    private void longestPalindromeCore(String s,int left,int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left; ++right;
        }

        this.left=left+1;
        this.right=right;
        this.length=right-left-1;
    }
}

class Solution3 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLength = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以自身为中心点进行扩散
            longestPalindromeCore(s, i, i);
            if (length > maxLength) {
                maxLength=length;
                maxLeft=left;
                maxRight=right;
            }

            if (i + 1 < s.length()) {
                longestPalindromeCore(s, i, i + 1);
                if (length > maxLength) {
                    maxLength=length;
                    maxLeft=left;
                    maxRight=right;
                }
            }

        }


        return s.substring(maxLeft,maxRight);
    }

    private int left, right, length;

    private void longestPalindromeCore(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        this.left = left + 1;
        this.right = right; // 不对right进行减一处理，刚好在subString中使用
        this.length = right - left - 1;
    }
}
