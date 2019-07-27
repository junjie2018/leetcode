package T0984;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().strWithout3a3b(1, 3));
    }
}

class Solution {
    public String strWithout3a3b(int A, int B) {

        StringBuilder sb = new StringBuilder();

        int a = A, b = B;
        while (a != b) {
            if (a > b) {
                if (a > 1) {
                    sb.append("aa");
                    a -= 2;
                    if (b > 0) {
                        sb.append("b");
                        b -= 1;
                    }
                } else {
                    sb.append("a");
                    a -= 1;
                }
            } else {
                if (b > 1) {
                    sb.append("bb");
                    b -= 2;
                    if (a > 0) {
                        sb.append("a");
                        a -= 1;
                    }
                } else {
                    sb.append("b");
                    b -= 1;
                }
            }
        }
        while (a > 0) {
            if (A >= B) {
                sb.append("a").append("b");
                a -= 1;
            } else {
                sb.append("b").append("a");
                a -= 1;
            }
        }


        return sb.toString();
    }
}
