package T0071;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().simplifyPath(
//                "/a/../../b/../c//.//"
//                "/a//b////c/d//././/.."
                "/a/./b/../../c/"
        ));
    }
}

/*
    坑！三个点被当做合法文件名处理了
 */
class Solution {
    public String simplifyPath(String path) {


        path = path.replaceAll("\\.\\.", "BACK");
        path = path.replaceAll("\\.", "");
        path = path.replaceAll("\\/+", "/");
        if (path.endsWith("/")) path = path.substring(0, path.length() - 1);

        String[] pathStrs = path.split("/");

        Stack<String> stack = new Stack<>();
        for (int i = 1; i < pathStrs.length; i++) {
            String pathStr = pathStrs[i];
            if ("BACK".equals(pathStr)) {
                if (stack.size() > 0) stack.pop();
            } else {
                stack.push(pathStr);
            }
        }

        if (stack.size() == 0) return "/";

        StringBuilder result = new StringBuilder();
        for (String s : stack) {
            result.append("/").append(s);
        }

        return result.toString();
    }
}

class Solution2 {
    public String simplifyPath(String path) {
        path = path.replaceAll("\\/+", "/");
        if (path.endsWith("/")) path = path.substring(0, path.length() - 1);

        String[] pathStrs = path.split("/");

        Stack<String> stack = new Stack<>();
        for (int i = 1; i < pathStrs.length; i++) {
            String pathStr = pathStrs[i];
            switch (pathStr) {
                case ".":
                    continue;
                case "..":
                    if (stack.size() > 0) stack.pop();
                    break;
                default:
                    stack.push(pathStr);
                    break;
            }
        }

        if (stack.size() == 0) return "/";

        StringBuilder result = new StringBuilder();
        for (String s : stack) {
            result.append("/").append(s);
        }

        return result.toString();
    }
}
