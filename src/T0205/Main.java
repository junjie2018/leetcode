package T0205;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();

        int[] s2t = new int[256], t2s = new int[256];

        for (int i = 0; i < len; i++) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if (s2t[sChar] == 0) {
                if (t2s[tChar] != 0) return false;
                s2t[sChar] = tChar;
                t2s[tChar] = sChar;
            } else {
                if (t2s[tChar] != sChar) return false;
            }
        }
        return true;
    }
}

/*
    这个想法太天真
 */
class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();

        int[] mapS = new int[256], mapT = new int[256];
        for (int i = 0; i < len; i++) {
            int idxS = s.charAt(i), idxT = t.charAt(i);
            mapS[idxS]++;
            mapT[idxT]++;
            if (mapS[idxS] != mapT[idxT]) return false;
        }
        return true;
    }
}
