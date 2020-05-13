package LeetCode.medium;

import LeetCode.common.ListNode;

/**
 * Created by bresai on 2016/11/28.
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer carry = 0;
        ListNode header = null;
        ListNode currentNode = null;
        char tmp = '0';
        while (!(l1 == null && l2 == null && carry == 0)){
            Integer result = (returnVal(l1) + returnVal(l2) + carry) % 10;
            carry = (returnVal(l1) + returnVal(l2) + carry) / 10;
            ListNode digit = new ListNode(result);
            if ( header == null){
                header = digit;
            }
            if (currentNode == null){
                currentNode = digit;
            } else{
                currentNode.next = digit;
                currentNode = digit;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        return header;
    }

    private Integer returnVal(ListNode node){
        return node == null ? 0 : node.val;
    }

    public static void main ( String[] args){
        AddTwoNumber object = new AddTwoNumber();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        ListNode header = object.addTwoNumbers(l1, l2);
    }

}
