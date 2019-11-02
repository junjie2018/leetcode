package T0521;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() > b.length() ? a.length() : b.length();
        }

        return a.equals(b) ? -1 : a.length();
    }
}
