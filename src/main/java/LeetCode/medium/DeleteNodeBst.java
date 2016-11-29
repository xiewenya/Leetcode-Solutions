package LeetCode.medium;

import LeetCode.common.TreeNode;

import java.util.LinkedList;

/**
 * Created by bresai on 2016/11/8.
 */
public class DeleteNodeBst {
    public TreeNode deleteNode(TreeNode root, int key) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val == key){
                if (node.left != null){
                    queue.add(0, node.left);
                }

            }else{
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return root;
    }
}
