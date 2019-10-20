package T0636;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        Collections.addAll(input, CommonUtils.createString1a("[\"0:start:0\",\"0:start:2\",\"0:end:5\",\"1:start:6\",\"1:end:6\",\"0:end:7\"]"));
        CommonUtils.show(new Solution().exclusiveTime(
                2, input
        ));

    }
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];

        Deque<Log> stack = new ArrayDeque<>();

        for (String log : logs) {
            Log cur = new Log(log);

            if (cur.start) {
                stack.push(cur);
            } else {
                Log top = stack.pop();
                result[top.id] += cur.timestamp - top.timestamp - top.innerTime + 1;
                if (stack.size() > 0) {
                    stack.peek().innerTime += cur.timestamp - top.timestamp + 1;
                }
            }
        }
        return result;
    }

    private static class Log {
        int id;
        boolean start;
        int timestamp;
        int innerTime;

        public Log(String log) {
            String[] logStrs = log.split(":");
            this.id = Integer.parseInt(logStrs[0]);
            this.start = "start".equals(logStrs[1]);
            this.timestamp = Integer.parseInt(logStrs[2]);
        }
    }
}
