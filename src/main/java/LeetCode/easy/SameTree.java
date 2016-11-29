package LeetCode.easy;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 16/9/8.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null){
            return ( p.val == q.val) &&
                    isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right);
        }
        return false;
    }
}
