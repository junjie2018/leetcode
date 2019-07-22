package Common;

import java.util.Arrays;
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

        Pattern r = Pattern.compile("[.*]");

        input = input.substring(1, input.length() - 1);
        String[] nums = input.split(",");

        int[][] result = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            result[i] = create(nums[i]);
        }
        return result;
    }
}
