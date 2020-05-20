package others.chapter4;

import others.common.BinaryTreeNode;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/20
 * @content:
 */
public class MinimalTree {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};

        BinaryTreeNode<Integer> node = buildSearchTree(array, 0, 8);
        StringBuilder builder = new StringBuilder();
        BinaryTreeNode.walkMiddle(node, builder);
        System.out.println(builder.toString());
    }

    public static BinaryTreeNode<Integer> buildSearchTree(int[] array, int start, int end){
        if (end < start){
            return null;
        }

        if (start == end){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
            node.setData(array[start]);
            return node;
        }

        int middle = start + (end - start) / 2 + (end - start) % 2;

        BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
        node.setData(array[middle]);

        node.setLeft(buildSearchTree(array, start, middle - 1));
        node.setRight(buildSearchTree(array, middle + 1, end));

        return node;
    }
}
