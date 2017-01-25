package LeetCode.medium;

import LeetCode.common.ListNode;

import java.util.Arrays;

/**
 * Created by bresai on 2017/1/24.
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode p2 = null;
        ListNode p1 = head;
        boolean duplicate = false;
        while (p1 != null){
            while(p1.next != null && p1.next.val == p1.val){
                p1 = p1.next;
            }

            if (p1.next.val == p1.val){
                if (! duplicate){
                    duplicate = true;
                }
                p1 = p1.next;
            } else{
                if (duplicate){
                    if ( p2 == null){
                        head = p1.next;
                        p2 = head;
                    } else{
                        p2.next = p1.next;
                    }
                    duplicate = false;
                } else{
                    p2 = p1;
                }
                p1 = p1.next;
            }
        }

        if (duplicate){
            if (p2 == null){
                return null;
            } else{
                p2.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args){
        ListNode head = ListNode.generateList(Arrays.asList(1,1,2,2));
        RemoveDuplicatesFromSortedList2 object = new RemoveDuplicatesFromSortedList2();
        ListNode.print(object.deleteDuplicates(head));
    }
}
