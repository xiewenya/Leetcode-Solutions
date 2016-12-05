package LeetCode.medium;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 2016/11/29.
 */
public class ValidateBinarySearchTree {

    private class Result {
        boolean result;
        Integer min;
        Integer max;

        public Result(boolean result, Integer min, Integer max) {
            this.result = result;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs_optimized(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        return dfs(root, null).result;
    }

    private boolean dfs_optimized(TreeNode node, long min, long max){
        if ( node == null){
            return true;
        }

        if (node.val <= min || node.val >= max) return false;

        boolean left = dfs_optimized(node.left, min, node.val);
        boolean right = dfs_optimized(node.right, node.val, max);
        return left && right;
    }


    private Result dfs(TreeNode node, Boolean direction){
        if (node.left == null && node.right == null){
            if (direction == null) return new Result(true, 0,0);
            if (direction)
                return new Result(true, node.val, null);
            else{
                return new Result(true, null, node.val);
            }
        }

        Result res1 = null;
        Result res2 = null;
        if (node.left != null){
            res1 = dfs(node.left, true);
            if (!res1.result ||
                    (res1.min != null && res1.min >= node.val) ||
                    ( res1.max != null && res1.max >= node.val))
                return new Result(false, 0, 0);

        }

        if (node.right != null){
            res2 = dfs(node.right, false);
            if (!res2.result ||
                    (res2.min != null &&res2.min <= node.val) ||
                    ( res2.max != null && res2.max <= node.val))
                return new Result(false, 0, 0);
        }

        if (direction == null) return new Result(true, 0, 0);

        return new Result(true,
                res1 == null ? node.val : res1.min,
                res2 == null ? node.val : res2.max);

    }

    public static void main (String[] args){
        Integer[] input = {5,14,null,1};
        TreeNode header = TreeNode.buildTree(input);
        ValidateBinarySearchTree object = new ValidateBinarySearchTree();
        System.out.println(object.isValidBST(header));
    }

}
