package others.chapter2;

import others.common.Node;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/11
 * @content:
 */
public class Intersection {
    public static void main(String[] args) {

    }

    public static boolean intersection(Node<Integer> node1, Node<Integer> node2){
        int size1 = length(node1);
        int size2 = length(node2);

        while (size1 > size2){
            node1 = node1.getNext();
            size1--;
        }

        while (size1 < size2){
            node2 = node2.getNext();
            size2--;
        }

        while (node1 != null){
            if (node1 == node2){
                return true;
            }

            node1 = node1.getNext();
            node2 = node2.getNext();
        }

        return false;
    }

    public static int length(Node<Integer> node){
        int count = 0;

        Node<Integer> head = node;

        while(head != null){
            count ++;
            head = head.getNext();
        }

        return count;
    }
}
