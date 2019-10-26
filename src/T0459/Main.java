package T0459;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        s = s + s;
        return s.substring(1, s.length() - 1).contains(s);
    }
}