package LeetCode.medium;

import LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bresai on 2016/9/30.
 */
public class BinaryTreeRightSideView {

    private Integer currentLevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map, currentLevel);
        return new ArrayList<>(map.values());
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map, Integer currentLevel) {
        if (root == null) return;


        if (!map.containsKey(currentLevel)){
            map.put(currentLevel, root.val);
        }

        currentLevel ++;
        dfs(root.right, map, currentLevel);
        dfs(root.left, map, currentLevel);
    }
}
