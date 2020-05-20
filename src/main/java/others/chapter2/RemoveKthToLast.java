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
public class RemoveKthToLast {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,5,2,2,3,6,7));

        Node<Integer> node = Node.buildList(list);

        System.out.println(removeKthToLast(node, 2));
        System.out.println(removeKthToLast(node, 10));

        list = new ArrayList<>(Arrays.asList(2));

        node = Node.buildList(list);
        System.out.println(removeKthToLast(node, 0));
        System.out.println(removeKthToLast(node, 1));
    }

    public static Node<Integer> removeKthToLast(Node<Integer> node, int k){
        if (node == null){
            return null;
        }

        Node<Integer> left = node;
        Node<Integer> right = node;

        int idx = 0;
        while (idx < k){
            if (right.getNext() == null){
                return null;
            }

            right = right.getNext();
            idx++;
        }

        while(right.getNext() != null){
            right = right.getNext();
            left = left.getNext();
        }

        return left;
    }
}
