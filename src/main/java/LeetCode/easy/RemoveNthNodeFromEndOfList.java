package LeetCode.easy;

import LeetCode.common.ListNode;

/**
 * Created by bresai on 2016/11/29.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n == 0) return head;

        if (head.next == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (n > 0 && fast.next != null){
            fast = fast.next;
            n--;
        }
        //remove the first
        if (n == 1){
            head = head.next;
            return head;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
