package others.chapter4;

import others.common.BinaryTreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/20
 * @content:
 */
public class ListOfDepths {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        BinaryTreeNode<Integer> node = BinaryTreeNode.buildTree(list);
        walk(map, node, 0);
        map.values().forEach(System.out::println);
    }

    public static void walk(HashMap<Integer, LinkedList<Integer>> map,
                            BinaryTreeNode<Integer> node, int level){
        if (node == null){
            return;
        }

        if (! map.containsKey(level)){
            map.put(level, new LinkedList<>());
        }

        map.get(level).add(node.getData());

        walk(map, node.getLeft(), level + 1);
        walk(map, node.getRight(), level + 1);
    }
}
