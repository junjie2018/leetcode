package T0771;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] map = new boolean[255];

        for (int i = 0; i < J.length(); i++) {
            map[J.charAt(i)] = true;
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (map[S.charAt(i)]) count++;
        }
        return count;
    }
}
