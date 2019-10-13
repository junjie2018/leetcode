package T0067;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary(
//                "11", "1"
//                "100", "110010"
                "101111", "10"
        ));
    }
}

/*
    这道题很简单，有很多解法，比如说将字符串转换成整数，运算后再还原成二进制，但是我无聊，想用这种方法解
 */
@SuppressWarnings("all")
class Solution {


    public String addBinary(String a, String b) {

        int lenA = a.length() - 1, lenB = b.length() - 1;

        int i = 0;
        char c = '0';
        StringBuilder sb = new StringBuilder();
        while (lenA - i >= 0 && lenB - i >= 0) {

            int oneCount = 0;
            if (c == '1') ++oneCount;
            if (a.charAt(lenA - i) == '1') ++oneCount;
            if (b.charAt(lenB - i) == '1') ++oneCount;

            switch (oneCount) {
                case 0:
                    c = '0';
                    sb.append('0');
                    break;
                case 1:
                    c = '0';
                    sb.append('1');
                    break;
                case 2:
                    c = '1';
                    sb.append('0');
                    break;
                case 3:
                    c = '1';
                    sb.append('1');
                    break;
            }
            i++;
        }

        while (lenA - i >= 0) {
            if (c == '1') {
                if (a.charAt(lenA - i) == '1') {
                    c = '1';
                    sb.append('0');
                } else {
                    c = '0';
                    sb.append('1');
                }
            } else {
                c = '0';
                sb.append(a.charAt(lenA - i));
            }
            i++;
        }
        while (lenB - i >= 0) {
            if (c == '1') {
                if (b.charAt(lenB - i) == '1') {
                    c = '1';
                    sb.append('0');
                } else {
                    c = '0';
                    sb.append('1');
                }
            } else {
                c = '0';
                sb.append(b.charAt(lenB - i));
            }
            i++;
        }
        if (c == '1') sb.append(c);
        return sb.reverse().toString();
    }
}