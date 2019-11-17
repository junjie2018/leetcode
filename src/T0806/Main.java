package T0806;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int cur = 0, layer = 1;
        for (int i = 0; i < S.length(); i++) {
            cur += widths[S.charAt(i) - 'a'];
            if (cur > 100) {
                cur = widths[S.charAt(i) - 'a'];
                ++layer;
            }
        }

        return new int[]{layer, cur};
    }
}
