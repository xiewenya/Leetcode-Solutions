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
public class Palindrome {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,3,5,3,2));

        Node<Integer> node = Node.buildList(list);

        System.out.println(node);
        System.out.println(palindrome(node));
    }

    public static boolean palindrome(Node<Integer> node){
        Node<Integer> runner = node;
        Node<Integer> reversed = null;
        while (runner != null){
            reversed = new Node<>(runner.getValue(), reversed);
            runner = runner.getNext();
        }

        while(node != null){
            if (!node.getValue().equals(reversed.getValue())){
                return false;
            }

            node = node.getNext();
            reversed = reversed.getNext();
        }

        return true;
    }
}
