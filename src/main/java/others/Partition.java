package others;

import others.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/11
 * @content:
 */
public class Partition {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,5,2,2,3,6,7));

        Node<Integer> node = Node.buildList(list);

        System.out.println(node);
        System.out.println(partition(node, 5));
    }

    public static Node<Integer> partition(Node<Integer> node, int x){

        if(node == null){
            return null;
        }

        Node<Integer> left = null,right = null;

        Node<Integer> headOfRight = null;
        Node<Integer> headOfLeft = null;

        while(node != null){
            if (node.getValue() < x){
                if (left == null){
                    left = node;
                    headOfLeft = left;
                }else{
                    left.setNext(node);
                    left = node;
                }
            } else{
                if (right == null){
                    right = node;
                    headOfRight = node;
                } else{
                    right.setNext(node);
                    right = node;
                }
            }

            node = node.getNext();
        }

        if (left == null){
            return headOfRight;
        }

        left.setNext(headOfRight);
        return headOfLeft;
    }
}
