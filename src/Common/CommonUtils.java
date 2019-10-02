package Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
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
                if (val) System.out.printf("%2d", 1);
                else System.out.printf("%2d", 0);
            }
            System.out.println();
        }
    }

    public static void show(String[] arrays) {
        System.out.println(Arrays.toString(arrays));
    }

    public static ListNode create(int[] array) {
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        for (int j = 0; j < array.length; j++) {
            curNode.next = new ListNode(array[j]);
            curNode = curNode.next;
        }
        return head.next;
    }

    public static ListNode[] create(int[][] arrays) {
        ListNode[] lists = new ListNode[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            lists[i] = create(arrays[i]);
        }
        return lists;
    }

    public static int[] create(String input) {
        input = input.replace('[', ' ');
        input = input.replace(']', ' ');
        String[] nums = input.split(",");

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = Integer.parseInt(nums[i].trim());
        }
        return result;
    }

    public static int[][] create2s(String input) {
//        String input = "[[1,2,3],[4,5,6],[7,8,9],[10,11,12],[13,14,15]]";

        Pattern outer = Pattern.compile("^\\[(.*)\\]$");
        Pattern inner = Pattern.compile("(\\[[^\\]]*\\])*,?");

        Matcher outMatcher = outer.matcher(input);

        int idx = 0;
        int[][] tmpResult = new int[1000][];
        if (outMatcher.find()) {
            String outerStr = outMatcher.group(1);
            Matcher innerMatcher = inner.matcher(outerStr);
            while (innerMatcher.find()) {
                String innerStr = innerMatcher.group(1);
                if (innerStr != null) tmpResult[idx++] = create(innerStr);
            }
        }

        return Arrays.copyOf(tmpResult, idx);
    }

    public static ListNode createL(String input) {
        String[] inputStrs = input.split("->");

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (String inputStr : inputStrs) {
            head.next = new ListNode(Integer.valueOf(inputStr.trim()));
            head = head.next;
        }
        return dummy.next;
    }
}
