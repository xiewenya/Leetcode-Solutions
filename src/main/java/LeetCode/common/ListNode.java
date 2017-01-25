package LeetCode.common;

import java.util.List;

/**
 * Created by bresai on 16/9/8.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode generateList(List<Integer> list){
        ListNode head = null;
        ListNode tmp = null;

        for (Integer integer : list){
            if (head == null){
                head = new ListNode(integer);
                tmp = head;
            } else{
                tmp.next = new ListNode(integer);
                tmp = tmp.next;
            }

        }

        return head;
    }

    public static void print(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
