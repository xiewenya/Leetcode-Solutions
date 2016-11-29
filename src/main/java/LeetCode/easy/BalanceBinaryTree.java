package LeetCode.easy;

import LeetCode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bresai on 16/9/11.
 */
public class BalanceBinaryTree {
    public boolean isBalanced(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();

        return checkBalance(root, map);
    }

    private boolean checkBalance(TreeNode node, Map<TreeNode, Integer> map){
        if (node == null){
            map.put(node, 0);
            return true;
        }

        if (checkBalance(node.left, map) && checkBalance(node.right, map)){
            if (Math.abs(map.get(node.left) - map.get(node.right)) > 1){
                return false;
            }
            int current = Math.max(map.get(node.left), map.get(node.right));
            map.put(node, current + 1);
            return true;
        }

        return false;
    }
}
