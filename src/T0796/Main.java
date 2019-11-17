package T0796;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() == 0) return true;

        String tmp = A + A + A;
        return tmp.indexOf(B) > 0;
    }
}