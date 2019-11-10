package T0657;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean judgeCircle(String moves) {
        int[] map = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R':
                    ++map[0];
                    break;
                case 'L':
                    --map[0];
                    break;
                case 'U':
                    ++map[1];
                    break;
                case 'D':
                    --map[1];
                    break;
            }
        }

        return map[0] == 0 && map[1] == 0;
    }
}