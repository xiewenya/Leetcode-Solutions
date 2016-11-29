package LeetCode.easy;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 2016/9/30.
 */
public class InverstBinaryTree {
    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null){
                return root;
            }

            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }
}
