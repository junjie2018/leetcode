package T0551;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord("PPALLL"));
    }
}

class Solution {
    public boolean checkRecord(String s) {

        boolean hasA = false;

        int preChar = ' ';
        int lCount = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A':
                    if (hasA) return false;
                    hasA = true;
                    lCount = 0;
                    break;
                case 'P':
                    lCount = 0;
                    break;
                case 'L':
                    if ('L' == preChar) {
                        ++lCount;
                        if (lCount >= 2) {
                            return false;
                        }
                    }
                    break;
            }
            preChar = s.charAt(i);
        }
        return true;
    }
}
