package T0006;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().convert("LEETCODEISHIRING",3));
    }
}

class Solution {
    public String convert(String s, int numRows) {

        if(numRows==1){
            return s;
        }

        int length = s.length();

        int chars = 2 * numRows - 2; // 从左到右一个循环含有的字符数
        int loops = (length+chars) / chars;
        char[] array = Arrays.copyOf(s.toCharArray(),loops*chars);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            // 处理第0行或者最后一行的数据
            if(i==0 || i==numRows-1){
                int loop = 0;

                while(loop * chars < length){
                    char c = array[loop*chars+i];
                    if(c!=0){
                        sb.append(c);
                    }
                    loop++;
                }
            }
            // 处理中间行的数据
            else {
                int right = i;
                int left = 2*numRows-2-i;

                int loop = 0;
                while(loop*chars < length){
                    char cr = array[loop*chars+right];
                    char cl = array[loop*chars+left];
                    if(cr!=0) sb.append(cr);
                    if(cl!=0) sb.append(cl);
                    loop++;
                }
            }
        }

        return sb.toString();
    }
}
