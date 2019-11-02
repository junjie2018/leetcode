package T0476;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
