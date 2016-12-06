package LeetCode.medium;

import LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by bresai on 2016/12/5.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode node){
        if (node == null) return;
        list.add(node.val);
        dfs(list, node.left);
        dfs(list, node.right);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (!(tmp == null && stack.isEmpty())){
            while(tmp != null){
                list.add(tmp.val);
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            tmp = tmp.right;
        }
        return list;
    }
}
