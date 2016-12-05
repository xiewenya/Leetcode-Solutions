package LeetCode.medium;

import LeetCode.common.TreeNode;

import java.util.Stack;

/**
 * Created by bresai on 2016/11/29.
 */
public class ValidateBinarySearchTreeIterative {


    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        TreeNode tmp = root;
        TreeNode pre = null;

        Stack<TreeNode> stack = new Stack<>();
        while (tmp != null || !stack.isEmpty()){
            while (tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            if (pre != null && tmp.val <= pre.val) return false;
            pre = tmp;
            tmp = tmp.right;
        }
        return true;
    }


    public static void main (String[] args){
        Integer[] input = {3,1,5,0,2,4,6,null, null, null, 3};
        TreeNode header = TreeNode.buildTree(input);
        ValidateBinarySearchTreeIterative object = new ValidateBinarySearchTreeIterative();
        System.out.println(object.isValidBST(header));
    }

}
