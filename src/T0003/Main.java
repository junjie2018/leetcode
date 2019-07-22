package T0003;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];

        for (int i = 0; i < map.length; i++) {
            map[i]=-1;
        }

        int i = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        while(i < s.length()){
            if(map[s.charAt(i)]==-1){
                count++;
                map[s.charAt(i)]=i;
                i++;
            }else {
                if(count>max){
                    max = count;
                }

                count=0;
                i=map[s.charAt(i)]+1;
                for (int j = 0; j < map.length; j++) {
                    map[j]=-1;
                }
            }
        }
        if(count>max){
            max = count;
        }
        return max;
    }
}
