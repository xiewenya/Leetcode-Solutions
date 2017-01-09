package LeetCode.medium;

import LeetCode.common.TreeNode;

/**
 * Created by bresai on 2017/1/6.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end){
        if (start > end){
            return null;
        }

        if (start == end){
            return new TreeNode(nums[start]);
        }

        int middle = start + (end - start)/2;
        TreeNode left = dfs(nums, start, middle - 1);
        TreeNode right = dfs(nums, middle + 1, end);
        TreeNode tmp = new TreeNode(nums[middle]);
        tmp.left = left;
        tmp.right = right;
        return tmp;
    }

    public static void main(String[] args){
        ConvertSortedArrayToBinarySearchTree object = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = {1,2,3,4};
        object.sortedArrayToBST(nums);
    }
}
