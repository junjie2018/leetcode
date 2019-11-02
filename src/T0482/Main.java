package T0482;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append(Character.toUpperCase(S.charAt(i)));
                count++;
                if (count == K) {
                    if (i != 0) sb.append('-');
                    count = 0;
                }
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }
}
