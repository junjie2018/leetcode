package T0010;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a"));
        System.out.println(new Solution().isMatch("aa", "a*"));
        System.out.println(new Solution().isMatch("aaa", "ab*a*c*a"));
        System.out.println(new Solution().isMatch("mississippi", "mis*is*p*."));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        char[] ss = new char[s.length()+1];
        char[] pp = new char[p.length()+1];

        System.arraycopy(s.toCharArray(),0,ss,1,s.length());
        System.arraycopy(p.toCharArray(),0,pp,1,p.length());

        boolean[][] stat = new boolean[pp.length][ss.length];
        stat[0][0] = true; // s和p中都不取字符时，匹配结果为true

        for (int i = 1; i < pp.length; i++) {
            char curP = pp[i];
            for (int j = 0; j < ss.length; j++) {
                char curS = ss[j];
                switch (curP){
                    case '*':
                        /*
                            '*' 有多层语义：
                               1. -1个其依附的值，stat[i-2][j]（令其依附的值为0个）
                               2. 0个其依附的值, stat[i-1][j]（不对其依附的值带来影响）
                               3. 1其依附的值，用[i-1]与ss[j]进行对比（类似于普通值，仅增加一个）
                               4. 多个其依附的值，判断首与ss[j]相等，如果相等，取pp[i-1]的值
                         */
                        boolean b1 = stat[i-2][j];
                        boolean b2 = stat[i-1][j];
                        boolean b3 = false;
                        if(equal(curS,pp[i-1])){
                            b3=stat[i-1][j-1];
                        }
                        boolean b4 = false;
                        if(equal(curS,pp[i-1])){
                            b4=stat[i][j-1];
                        }
                        stat[i][j]=b1 || b2 || b3 || b4;
                        break;
                    default:
                        if(equal(curS,curP)){
                            stat[i][j]=stat[i-1][j-1];
                        }else {
                            stat[i][j] = false;
                        }
                        break;
                }
            }
        }

//        for(boolean[] inner : stat){
//            for(boolean value : inner){
//                System.out.print((value?1:0)+" ");
//            }
//            System.out.println();
//        }

        return stat[p.length()][s.length()];
    }

    private boolean equal(char s, char p){
        if(p=='.'){
            return s!=0;
        }else {
            return s==p;
        }
    }
}
