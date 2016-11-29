package LeetCode.easy;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 16/9/8.
 */
public class TreeDistance {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        return check(root, 1);
    }

    private int check(TreeNode node, int n){
        if (node.left == null && node.right == null){
            return n;
        }
        int left = 0;
        int right = 0;
        if (node.left != null){
            left = check(node.left, n+1);
        }

        if (node.right != null){
            right = check(node.right, n+1);
        }

        return (left > right) ? left : right;
    }
}
