package others;

import others.common.Node;

import java.util.*;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/11
 * @content:
 */
public class RemoveDups {

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,5,2,2,3,6,7));

        Node<Integer> node = Node.buildList(list);

        System.out.println(node.toString());

        removeDup(node);

        System.out.println(node.toString());

        node = Node.buildList(list);

        System.out.println(node.toString());

        removeDup1(node);

        System.out.println(node.toString());
    }

    public static void removeDup(Node<Integer> node){
        if (node == null){
            return;
        }

        Node<Integer> head = node.getNext();
        Node<Integer> prev = node;
        Set<Integer> set = new HashSet<>();
        set.add(prev.getValue());

        while (head != null){
            if (set.contains(head.getValue())){
                prev.setNext(head.getNext());
                head = head.getNext();
            } else{
                set.add(head.getValue());
                prev = head;
                head = head.getNext();
            }

        }
    }

    public static void removeDup1(Node<Integer> node){
        Node<Integer> left = node;

        while(left != null){
            Node<Integer> right = left.getNext();
            Node<Integer> prev = left;
            while(right != null){
                if (left.getValue().equals(right.getValue())){
                    prev.setNext(right.getNext());
                    right = right.getNext();
                } else{
                    right = right.getNext();
                    prev = prev.getNext();
                }
            }

            left = left.getNext();
        }
    }
}
