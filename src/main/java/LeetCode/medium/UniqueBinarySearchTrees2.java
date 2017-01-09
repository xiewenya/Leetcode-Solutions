package LeetCode.medium;

import LeetCode.common.TreeNode;

import java.util.*;

/**
 * Created by bresai on 2017/1/6.
 */
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }

        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end){
        if (start > end){
            return new ArrayList<>(Collections.singletonList(null));
        }
        if (start == end){
            return new ArrayList<>(Collections.singletonList(new TreeNode(start)));
        }

        List<TreeNode> result = new ArrayList<>();
        for(int i = start; i <= end; i++){
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);
            for (TreeNode nodeLeft : left){
                for (TreeNode nodeRight : right){
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = nodeLeft;
                    tmp.right = nodeRight;
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}
