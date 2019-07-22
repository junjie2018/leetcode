package T0038;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().countAndSay(3));
    }
}

class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder().append('1');
        for (int i = 1; i < n; i++) {
            char pre = sb.charAt(0);
            int count = 1;
            StringBuilder tmp = new StringBuilder();
            for (int j = 1; j < sb.length(); j++) {
                if(sb.charAt(j)==pre){
                    count++;
                }else {
                    if(count!=0){
                        tmp.append(pre).append(count);
                    }
                    pre = sb.charAt(j);
                    count=1;
                }
            }
            if(count!=0){
                tmp.append(pre).append(count);
            }
            sb=tmp;
        }
        return sb.reverse().toString();
    }
}

class Solution2 {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder().append('1');
        for (int i = 1; i < n; i++) {
            char pre = sb.charAt(0);
            int count = 1;
            StringBuilder tmp = new StringBuilder();
            for (int j = 1; j < sb.length(); j++) {
                if(sb.charAt(j)==pre){
                    count++;
                }else {
                    tmp.append(count).append(pre);
                    pre=sb.charAt(j);
                    count=1;
                }
            }
            tmp.append(count).append(pre);
            sb=tmp;
        }
        return sb.toString();
    }
}
