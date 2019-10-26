package T0415;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int idx1 = num1.length() - 1, idx2 = num2.length() - 1;

        int c = 0;
        while (idx1 >= 0 && idx2 >= 0) {
            int sum = num1.charAt(idx1) - '0' + num2.charAt(idx2) - '0' + c;
            sb.append(sum % 10);
            c = sum / 10;

            --idx1;
            --idx2;
        }

        while (idx1 >= 0) {
            int sum = num1.charAt(idx1) - '0' + c;
            sb.append(sum % 10);
            c = sum / 10;
            --idx1;
        }

        while (idx2 >= 0) {
            int sum = num2.charAt(idx2) - '0' + c;
            sb.append(String.valueOf(sum % 10));
            c = sum / 10;
            --idx2;
        }

        if (c != 0) sb.append(c);

        return sb.reverse().toString();
    }
}
