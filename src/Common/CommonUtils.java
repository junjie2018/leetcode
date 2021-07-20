package Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

    private static Pattern outer = Pattern.compile("^\\[(.*)\\]$");
    private static Pattern inner = Pattern.compile("(\\[[^\\]]*\\])*,?");

    public static void show(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void show(int[][] arrays) {
        for (int[] inner : arrays) {
            System.out.println(Arrays.toString(inner));
        }
    }

    public static void show(boolean[][] arrays) {
        for (boolean[] inner : arrays) {
            for (boolean val : inner) {
                if (val) {
                    System.out.printf("%2d", 1);
                } else {
                    System.out.printf("%2d", 0);
                }
            }
            System.out.println();
        }
    }

    public static void show(String[] arrays) {
        System.out.println(Arrays.toString(arrays));
    }

    public static void show(int[] array) {
        System.out.println(Arrays.toString(array));
    }


    // [1,2,3]
    public static int[] createIntArrayFromString(String input) {
        input = input.replace('[', ' ');
        input = input.replace(']', ' ');

        String[] nums = input.split(",");

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = Integer.parseInt(nums[i].trim());
        }
        return result;
    }


    // [[1,2,3],[1,2,3],[1,2,3]]
    public static int[][] createInt2a(String input) {


        Matcher outMatcher = outer.matcher(input);

        int idx = 0;
        int[][] tmpResult = new int[1000][];
        if (outMatcher.find()) {
            String outerStr = outMatcher.group(1);
            Matcher innerMatcher = inner.matcher(outerStr);
            while (innerMatcher.find()) {
                String innerStr = innerMatcher.group(1);
                if (innerStr != null) {
                    tmpResult[idx++] = createIntArrayFromString(innerStr);
                }
            }
        }

        return Arrays.copyOf(tmpResult, idx);
    }

    // ['a','b','c']
    public static char[] createChar1a(String input) {
        input = input.replace('[', ' ');
        input = input.replace(']', ' ');
        String[] chars = input.split(",");

        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i].trim().toCharArray()[1];
        }
        return result;
    }


    // ["abc","abc","abc"]
    public static String[] createString1a(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);

        String[] inputStrs = input.split(",");
        String[] result = new String[inputStrs.length];
        for (int i = 0; i < inputStrs.length; i++) {
            inputStrs[i] = inputStrs[i].trim();
            result[i] = inputStrs[i].substring(1, inputStrs[i].length() - 1);
        }
        return result;
    }

    // [["abc","abc"],["abc","abc","abc"]]
    public static List<List<String>> createString2l(String input) {
        Pattern outer = Pattern.compile("^\\[(.*)\\]$");
        Pattern inner = Pattern.compile("(\\[[^\\]]*\\])*,?");

        Matcher outMatcher = outer.matcher(input);

        List<List<String>> result = new ArrayList<>();
        if (outMatcher.find()) {
            String outerStr = outMatcher.group(1);
            Matcher innerMatcher = inner.matcher(outerStr);


            while (innerMatcher.find()) {
                List<String> innerResult = new ArrayList<>();
                String innerStr = innerMatcher.group(1);
                if (innerStr != null && innerStr.length() > 0 && !"[]".equals(innerStr)) {
                    Collections.addAll(innerResult, createString1a(innerStr));
                    result.add(innerResult);
                }
            }

        }

        return result;
    }

    // 1->2->3->4
    public static ListNode createListNode(String input) {
        String[] inputStrs = input.split("->");

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (String inputStr : inputStrs) {
            head.next = new ListNode(Integer.valueOf(inputStr.trim()));
            head = head.next;
        }
        return dummy.next;
    }

    // [1,2,3,4]
    public static ListNode createListNode(int[] array) {
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        for (int j = 0; j < array.length; j++) {
            curNode.next = new ListNode(array[j]);
            curNode = curNode.next;
        }
        return head.next;
    }

    // [[1,2,3,4],[1,2,3,4],[1,2,3,4]]
    public static ListNode[] createListNode1a(int[][] arrays) {
        ListNode[] lists = new ListNode[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            lists[i] = createListNode(arrays[i]);
        }
        return lists;
    }

    public static TreeNode createTreeNode(String input) {
        input = input.substring(1, input.length() - 1);

        String[] split = input.split(",");

        TreeNode[] treeNodes = new TreeNode[split.length];

        for (int i = 0; i < split.length; i++) {
            if (!"null".equals(split[i])) {
                treeNodes[i] = new TreeNode(Integer.valueOf(split[i]));
            }
        }

        for (int i = 0; i < treeNodes.length; i++) {
            if (treeNodes[i] != null) {
                if (2 * i + 1 < treeNodes.length) {
                    treeNodes[i].left = treeNodes[2 * i + 1];
                }
                if (2 * i + 2 < treeNodes.length) {
                    treeNodes[i].right = treeNodes[2 * i + 2];
                }
            }
        }

        return treeNodes[0];
    }
}
