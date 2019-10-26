package T0409;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println(new Solution().longestPalindrome("bb"));
    }
}

class Solution {
    public int longestPalindrome(String s) {

        System.out.println(s.length());

        int[] map = new int[256];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }

        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (map[i] != 0) {
                if (map[i] % 2 == 1) {
                    count++;
                }
            }
        }

        if(count>0) --count;

        return s.length() - count;
    }
}
