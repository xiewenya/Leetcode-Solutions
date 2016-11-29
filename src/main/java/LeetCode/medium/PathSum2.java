package LeetCode.medium;

import LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bresai on 16/9/11.
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        return getPath(root, 0, sum, result, list);
    }

    private List<List<Integer>> getPath(TreeNode node, int current, int sum, List<Integer> result, List<List<Integer>> results){
        if (node == null){
            if (sum == current){
                results.add(result);
            }
            return results;
        }

        result.add(node.val);
        if (node.left == null){
            getPath(node.right, current+ node.val, sum, result, results);
        }else if (node.right == null) {
            getPath(node.left, current + node.val, sum, result, results);
        } else{
            getPath(node.right, current+ node.val, sum, result, results);
            getPath(node.left, current+ node.val, sum, result, results);
        }

        return results;
    }

    public static void main(String[] args){
        Integer[] array = {5,4,8,11,-1,13,4,7,2,-1,-1,5,1};
        int sum = 22;
        new PathSum2().pathSum(TreeNode.getFromList(array, 1), sum);
    }
}
