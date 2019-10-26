package T0299;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1123", "0111"));
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        int[] map = new int[10];

        int len = secret.length();

        int aCount = 0;
        for (int i = 0; i < len; i++) {
            map[secret.charAt(i) - '0']++;
            map[guess.charAt(i) - '0']--;
            if (secret.charAt(i) == guess.charAt(i)) aCount++;
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (map[i] > 0) count += map[i];
        }

        int bCount = len - count - aCount;

        return String.format("%dA%dB", aCount, bCount);
    }
}