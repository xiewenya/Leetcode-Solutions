package others.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/20
 * @content:
 */

public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public static <T> BinaryTreeNode<T> buildTree(List<T> list){
        HashMap<Integer, Integer> map = new HashMap<>();
        return buildTree(map, list, 0);
    }

    private static <T> BinaryTreeNode<T> buildTree(HashMap<Integer, Integer> map, List<T> list, int level){
        double tmp =  Math.pow(2, level) - 1;
        int idx = (int) tmp;
        if (map.containsKey(level)){
            idx += map.get(level);
        }

        if (idx >= list.size()){
            return null;
        }

        BinaryTreeNode<T> node = new BinaryTreeNode<>();
        node.data = list.get(idx);

        if (map.containsKey(level)){
            map.put(level, map.get(level) + 1);
        } else {
            map.put(level, 1);
        }
        node.left = buildTree(map, list, level + 1);
        node.right = buildTree(map, list, level + 1);

        return node;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        walkFront(this, builder);

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static <T> void walkMiddle(BinaryTreeNode<T> node, StringBuilder builder){
        if (node == null){
            return;
        }

        walkMiddle(node.left, builder);

        builder.append(node.data).append(",");

        walkMiddle(node.right, builder);
    }

    public static <T> void walkBack(BinaryTreeNode<T> node, StringBuilder builder){
        if (node == null){
            return;
        }

        walkBack(node.left, builder);
        walkBack(node.right, builder);

        builder.append(node.data).append(",");
    }

    public static <T> void walkFront(BinaryTreeNode<T> node, StringBuilder builder){
        if (node == null){
            return;
        }

        builder.append(node.data).append(",");

        walkFront(node.left, builder);
        walkFront(node.right, builder);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        BinaryTreeNode<Integer> node = buildTree(list);

        System.out.println(node.toString());

    }
}
