package LeetCode.medium;

import LeetCode.common.TreeNode;

import java.util.*;

/**
 * Created by bresai on 2016/11/29.
 */
public class BinaryTreeInorderTranversal {
    //recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode node, List<Integer> list){
        if (node == null) return;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    //iterative
    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Map<TreeNode, Boolean> seen = new HashMap<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node.left == null || seen.containsKey(node.left)){
                list.add(node.val);
                stack.pop();
                seen.put(node, true);
                if (node.right != null){
                    stack.push(node.right);
                }
            }else{
                stack.push(node.left);
            }
        }
        return list;
    }

    //iterative online solution
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode tmp = root;
        if (root == null) return list;
        stack.push(root);

        while (!(stack.isEmpty()&& tmp == null)){
            while(tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            tmp = node.right;
        }
        return list;
    }

}
