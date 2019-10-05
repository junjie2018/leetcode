package T1138;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().alphabetBoardPath(
//                "leet"
                "code"
        ));
    }
}

// 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。
class Solution {
    public String alphabetBoardPath(String target) {
        Map<Character, Point> map = new HashMap<>();
        for (char i = 0; i < 26; i++) {
            map.put((char) (i + 'a'), new Point(i % 5, i / 5));
        }

        Point cur = new Point(0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            Point point = map.get(target.charAt(i));

            int rowSteps = point.x - cur.x;
            int colSteps = point.y - cur.y;

            // point可能为z点
            if (rowSteps < 0) {
                char rowChar = 'L';
                char colChar = colSteps < 0 ? 'U' : 'D';
                for (int j = 0; j < Math.abs(rowSteps); j++) {
                    sb.append(rowChar);
                }
                for (int j = 0; j < Math.abs(colSteps); j++) {
                    sb.append(colChar);
                }
                sb.append('!');
            }
            // cur可能为z点
            else {
                char rowChar = 'R';
                char colChar = colSteps < 0 ? 'U' : 'D';
                for (int j = 0; j < Math.abs(colSteps); j++) {
                    sb.append(colChar);
                }
                for (int j = 0; j < Math.abs(rowSteps); j++) {
                    sb.append(rowChar);
                }
                sb.append('!');
            }
            cur = point;
        }

        return sb.toString();
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
