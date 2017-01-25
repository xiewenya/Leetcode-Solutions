package LeetCode.medium;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 2017/1/9.
 */
public class FlattenBinaryTreeToLinkedList {

    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        perOrder(root);
    }

    private void perOrder(TreeNode root){
        if (root == null){
            return;
        }

        if (lastNode != null){
            lastNode.right = root;
            lastNode.left = null;
        }

        lastNode = root;
        TreeNode right = root.right;
        perOrder(root.left);
        perOrder(right);
    }
}
