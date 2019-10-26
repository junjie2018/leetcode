package T0443;

public class Main {
    public static void main(String[] args) {
        new Solution().compress(new char[]{
                'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'
        });
    }
}

class Solution {
    public int compress(char[] chars) {

        int idx = 0;
        char preChar = chars[0];
        int preCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != preChar) {
                if (preCount == 1) {
                    chars[idx++] = preChar;
                } else {
                    chars[idx++] = preChar;
                    String preCountStr = String.valueOf(preCount);
                    for (int j = 0; j < preCountStr.length(); j++) {
                        chars[idx++] = preCountStr.charAt(j);
                    }
                }

                preChar = chars[i];
                preCount = 1;
                continue;
            }

            preCount++;
        }

        if (preCount == 1) {
            chars[idx++] = preChar;
        } else {
            chars[idx++] = preChar;
            String preCountStr = String.valueOf(preCount);
            for (int j = 0; j < preCountStr.length(); j++) {
                chars[idx++] = preCountStr.charAt(j);
            }
        }

        return idx;
    }
}
