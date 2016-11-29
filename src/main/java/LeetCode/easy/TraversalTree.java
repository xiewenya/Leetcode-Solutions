package LeetCode.easy;

import LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bresai on 16/9/8.
 */
public class TraversalTree {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if ( root == null ) {
            return list;
        }
        list = check(root, list, 1);
        return list;
    }

    private List<List<Integer>> check(TreeNode node, List<List<Integer>> list, Integer layer){
        if ( node == null ) return list;

        List<Integer> tmp;

        try{
            tmp = list.get(layer);
            tmp.add(node.val);
        } catch (Exception e){
            tmp = new ArrayList<>();
            tmp.add(node.val);
            list.add(layer, tmp);
        }

        if ( node.left != null ){
            list = check(node.left, list, layer + 1);
        }
        if ( node.right != null){
            list = check(node.right, list, layer + 1);
        }

        return list;
    }
}
