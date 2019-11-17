package T0824;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String toGoatLatin(String S) {
        String[] strs = S.split("\\s+");

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder(strs[i]);

            char c = sb.charAt(0);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'
                    && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                sb.deleteCharAt(0);
                sb.append(c);
            }

            sb.append("ma");
            fillA(sb, i + 1);
            res.append(sb.toString()).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private void fillA(StringBuilder sb, int count) {
        while (count > 0) {
            sb.append("a");
            --count;
        }
    }
}
