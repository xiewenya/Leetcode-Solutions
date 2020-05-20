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
public class FindCommonAncestor {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        BinaryTreeNode<Integer> node = BinaryTreeNode.buildTree(list);

        System.out.println(ancestor(node, 2, 9));
    }

    public static Pair<BinaryTreeNode<Integer>, Boolean> ancestor(BinaryTreeNode<Integer> node, int target1, int target2){
        if (node == null){
            return new Pair<>(null, false);
        }

        Pair<BinaryTreeNode<Integer>, Boolean> left = ancestor(node.getLeft(), target1, target2);
        Pair<BinaryTreeNode<Integer>, Boolean> right = ancestor(node.getRight(), target1, target2);

        if (left.getKey() != null){
            return left;
        }

        if (right.getKey() != null){
            return right;
        }

        if (left.getValue() && right.getValue()){
            return new Pair<>(node, true);
        }

        if(node.getData() == target1 || node.getData() == target2){
            if (left.getValue() || right.getValue()){
                return new Pair<>(node, true);
            } else {
                return new Pair<>(null, true);
            }
        }else{
            if (left.getValue() || right.getValue()){
                return new Pair<>(null, true);
            } else {
                return new Pair<>(null, false);
            }
        }
    }
}
