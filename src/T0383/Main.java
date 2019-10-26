package T0383;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            map[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            if (map[magazine.charAt(i) - 'a'] != 0) {
                map[magazine.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) return false;
        }

        return true;
    }
}