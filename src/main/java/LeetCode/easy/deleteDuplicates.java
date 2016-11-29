package LeetCode.easy;

import LeetCode.common.ListNode;

/**
 * Created by bresai on 16/9/8.
 */
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return head;
        }
        ListNode tmp = head;
        while (tmp.next != null){
            if (tmp.val == tmp.next.val){
                tmp.next = tmp.next.next;
            }else{
                tmp = tmp.next;
            }

        }
        return head;
    }
}
