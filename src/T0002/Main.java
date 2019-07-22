package T0002;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);


        show(new Solution().addTwoNumbers(l1,l2));
//        show(l1);
//        show(l2);
    }

    private static void show(ListNode listNode){
        while(listNode!=null){
            System.out.print(listNode.val+ " ");
            listNode=listNode.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int c = 0; // 记录进位
        ListNode head = new ListNode(-1); // 作为头结点
        ListNode curNode = head;
        while(l1 != null && l2 != null){

            curNode.next=new ListNode((l1.val+l2.val + c) % 10);
            c = (l1.val+l2.val + c) / 10;

            l1=l1.next; l2=l2.next;
            curNode=curNode.next;
        }

        // 处理较长的数字
        ListNode temp = l1 != null ? l1:l2;
        while(temp!=null){
            curNode.next=new ListNode((temp.val+c)%10);
            c=(temp.val+c)/10;

            temp=temp.next;
            curNode=curNode.next;
        }

        // 处理最后的进位
        if(c != 0){
            curNode.next=new ListNode(c);
        }
        return head.next;
    }
}
