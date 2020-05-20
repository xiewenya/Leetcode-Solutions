package others.chapter4;

import javafx.util.Pair;
import others.common.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/20
 * @content:
 */
public class CheckBalanced {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        BinaryTreeNode<Integer> node = BinaryTreeNode.buildTree(list);

        System.out.println(check(node));
    }

    public static Pair<Integer, Boolean> check(BinaryTreeNode<Integer> node){
        if (node == null){
            return new Pair<>(0, true);
        }


        Pair<Integer, Boolean> left = check(node.getLeft());
        Pair<Integer, Boolean> right = check(node.getRight());

        if (!left.getValue() || !right.getValue()){
            return new Pair<>(0, false);
        }

        if (Math.abs(left.getKey() - right.getKey()) > 1){
            return new Pair<>(0, false);
        }

        return new Pair<>(left.getKey() > right.getKey()? left.getKey() + 1: right.getKey() + 1, true);
    }
}
