package LeetCode.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bresai on 16/9/8.
 */
public class TreeNode {
      public Integer val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(Integer x) { val = x; }

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

      public static TreeNode buildTree(Integer[] list){
            if (list.length == 0) return null;
            return dfs(list, 0);
      }

      private static TreeNode dfs(Integer[] list, int index){
            if (index >= list.length) return null;
            if (list[index] == null) return null;
            TreeNode node = new TreeNode(list[index]);
            node.left = dfs(list, 2*(index + 1) - 1);
            node.right = dfs(list, 2*(index + 1));
            return node;
      }


      public static void printTree(TreeNode header){
            TreeNode node = header;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node);
            while (! queue.isEmpty()){
                  TreeNode tmp = queue.poll();
                  if (tmp.left != null)
                        queue.offer(tmp.left);
                  if (tmp.right != null)
                        queue.offer(tmp.right);
                  System.out.print(tmp.val);
                  System.out.print(",");
            }
      }

      public static void main (String[] args){
            Integer[] input = {3,1,5,0,2,4,6,null,null,null,3};
            TreeNode header = buildTree(input);
            printTree(header);
      }

}
