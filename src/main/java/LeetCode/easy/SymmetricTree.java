package LeetCode.easy;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 16/9/8.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return (checkTree(root, root));
    }

    private boolean checkTree(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        if ( left.val == right.val ){
            return checkTree(left.left, right.right) && checkTree(left.right, right.left);
        }

        return false;
    }
}



