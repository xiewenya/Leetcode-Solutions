package LeetCode.easy;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 16/9/11.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        return checkSum(root, sum, 0);
    }

    private boolean checkSum(TreeNode root, int sum, int current){
        if (root == null){
            return current == sum;
        }

        current += root.val;
        if (root.left == null){
            return checkSum(root.right, sum, current);
        }
        if (root.right == null){
            return checkSum(root.left, sum, current);
        }
        return checkSum(root.left, sum, current) | checkSum(root.right, sum, current);
    }
}
