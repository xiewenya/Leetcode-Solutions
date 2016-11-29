package LeetCode.common;

/**
 * Created by bresai on 16/9/8.
 */
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode(int x) { val = x; }

      public static TreeNode getFromList(Integer[] list, int index){
            if(index > list.length){
                  return null;
            }
            Integer value = list[index - 1];
            if(value != -1){
                  TreeNode node = new TreeNode(value);
                  node.left = getFromList(list, index*2);
                  node.right = getFromList(list, index*2 + 1);
                  return node;
            }
            return null;
      }
}
