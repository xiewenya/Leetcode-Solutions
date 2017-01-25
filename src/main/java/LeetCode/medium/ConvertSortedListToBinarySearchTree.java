package LeetCode.medium;

import LeetCode.common.ListNode;
import LeetCode.common.TreeNode;

/**
 * Created by bresai on 2017/1/6.
 */
public class ConvertSortedListToBinarySearchTree {
    private ListNode next;

    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        next = head;
        ListNode tmp = head;
        while (tmp!= null){
            tmp = tmp.next;
            count++;
        }
        return dfs(count);
    }

    private TreeNode dfs(int n){
        if (n == 0){
            return null;
        }

        if (n == 1){
            TreeNode node = new TreeNode(next.val);
            next = next.next;
            return node;
        }

        int midNode = n/2;
        TreeNode left = dfs(midNode);
        TreeNode node = new TreeNode(next.val);
        node.left = left;
        next = next.next;
        node.right = dfs(n - midNode - 1);
        return node;
    }
}
