package LeetCode.easy;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 2017/1/5.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val.equals(p.val) || root.val.equals(q.val)){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root;
        }

        if (left != null){
            return left;
        }

        if (right != null){
            return right;
        }

        return null;
    }

}
