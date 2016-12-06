package LeetCode.hard;

import LeetCode.common.TreeNode;

import java.util.*;

/**
 * Created by bresai on 2016/12/5.
 */
public class BinaryTreePostrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode node){
        if (node == null) return;
        dfs(list, node.left);
        dfs(list, node.right);
        list.add(node.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> map = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (!(tmp == null && stack.isEmpty())){
            while(tmp != null){
                stack.push(tmp);
                tmp = tmp.left;

            }
            tmp = stack.peek();
            if ((tmp.left == null || map.contains(tmp.left))
                    && (tmp.right == null || map.contains(tmp.right))) {
                list.add(tmp.val);
                map.add(tmp);
                tmp = stack.pop();
            }
            if (tmp.right == null || map.contains(tmp.right)) tmp = null;
            else tmp = tmp.right;
        }
        return list;
    }
}
