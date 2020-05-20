package others.chapter4;

import others.common.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/20
 * @content:
 */
public class ValidateBst {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,12,3,4,5,6,7,8,9);
        BinaryTreeNode<Integer> node = BinaryTreeNode.buildTree(list);

        System.out.println(walk(node));
    }

    public static boolean walk(BinaryTreeNode<Integer> node){
        if (node == null){
            return true;
        }

        if (node.getLeft() == null && node.getRight() == null){
            return true;
        }

        if (node.getLeft() == null){
            return walk(node.getRight());
        }

        if (node.getRight() == null){
            return walk(node.getLeft());
        }

        if (node.getLeft().getData() > node.getRight().getData()){
            return false;
        }


        boolean left = walk(node.getLeft());
        if (!left){
            return false;
        }

        return walk(node.getRight());
    }
}
