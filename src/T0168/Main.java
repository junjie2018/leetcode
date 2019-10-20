package T0168;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(52));
    }
}

class Solution {
    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        do {
            if (n % 26 == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            } else {
                sb.append((char) (((n % 26 + 25) % 26 + 'A')));
                n /= n;
            }
        } while (n > 0);

        return sb.reverse().toString();
    }
}
