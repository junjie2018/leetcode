package T0909;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().transferToNode(7, 6).toString());
        System.out.println(new Solution().snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
//                {-1, 7, -1},
//                {-1, 6, 9},
//                {-1, -1, 2}
//                {-1, -1, -1},
//                {-1, 9, 8},
//                {-1, 8, 9}
//                {1, 1, -1},
//                {1, 1, 1},
//                {-1, 1, 1}
        }));
    }
}

class Solution {

    private int N;

    public int snakesAndLadders(int[][] board) {

        this.N = board.length;

        // 用来记录已经往queue塞过的节点
        boolean[][] stat = new boolean[N][N];

        Deque<Node> queue = new ArrayDeque<>();
        Node node = transferToNode(1);
        stat[node.x][node.y] = true;
        queue.addFirst(node);

        int steps = 1, counts = queue.size();
        while (queue.size() > 0) {

            Node removeNode = queue.removeLast();

            for (int i = 1; i <= 6; i++) {
                if (removeNode.val + i > N * N) break;
                if (removeNode.val + i == N * N) return steps;

                node = transferToNode(removeNode.val + i);

                if (board[node.x][node.y] != -1) {
                    if (board[node.x][node.y] == N * N) return steps;
                    node = transferToNode(board[node.x][node.y]);
                }

                if (!stat[node.x][node.y]) {
                    stat[node.x][node.y] = true;
                    queue.addFirst(node);
                }
            }

            counts--;
            if (counts == 0) {
                steps++;
                counts = queue.size();
            }
        }

        return -1;
    }

    private Node transferToNode(int position) {
        int x, y;
        if (position % N == 0) {
            x = position / N;
            y = x % 2 == 1 ? N : 1;
        } else {
            x = position / N + 1;
            y = x % 2 == 1 ? position % N : N - position % N + 1;
        }
        return new Node(position, N - x, y - 1);
    }

    public static class Node {
        int x, y;
        int val;

        Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("X:%d, Y:%d", x, y);
        }
    }
}


