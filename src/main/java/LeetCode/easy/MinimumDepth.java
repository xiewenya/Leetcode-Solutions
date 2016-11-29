package LeetCode.easy;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 16/9/11.
 */
public class MinimumDepth {
    public int minDepth(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode root, int length){
        if (root == null){
            return length;
        }

        if (root.left == null){
            return depth(root.right, length+1);
        }

        if (root.right == null){
            return depth(root.left, length+1);
        }

        return Math.min(depth(root.left, length+1), depth(root.right, length+1));
    }
}
