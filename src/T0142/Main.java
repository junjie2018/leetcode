package T0142;

import Common.ListNode;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        while (tmp != null) {
            if (set.contains(tmp)) {
                return tmp;
            }
            set.add(tmp);
            tmp = tmp.next;
        }
        return null;
    }
}

/*
    用我之前那种投机取巧的方法
 */
class Solution2 {
    public ListNode detectCycle(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val > 50000) {
                tmp.val -= 80000;
                return tmp;
            }
            tmp.val += 80000;
            tmp = tmp.next;
        }
        return null;
    }
}