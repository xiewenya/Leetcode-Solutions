package others.chapter2;

import others.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/11
 * @content:
 */
public class DeleteMiddleNode {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,5,2,3,6,7));

        Node<Integer> node = Node.buildList(list);

        System.out.println(node);

        deleteMiddleNode(node);

        System.out.println(node);

        list = new ArrayList<>(Arrays.asList(2,3,6,7));

        node = Node.buildList(list);

        System.out.println(node);

        deleteMiddleNode(node);

        System.out.println(node);

        list = new ArrayList<>(Arrays.asList(2,3));

        node = Node.buildList(list);

        System.out.println(node);

        deleteMiddleNode(node);

        System.out.println(node);
    }

    public static void deleteMiddleNode(Node<Integer> node){
        if (node == null){
            return;
        }

        Node<Integer> left = node;
        Node<Integer> right = node;
        Node<Integer> prev = null;

        while (right.getNext() != null && right.getNext().getNext() != null){
            right = right.getNext().getNext();
            prev = left;
            left = left.getNext();
        }

        if (prev == null){
            return;
        }

        prev.setNext(left.getNext());
    }
}
