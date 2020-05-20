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
public class SumList {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 5, 5));

        Node<Integer> num1 = Node.buildList(list);

        list = new ArrayList<>(Arrays.asList(3, 5));

        Node<Integer> num2 = Node.buildList(list);

        System.out.println(num1);
        System.out.println(num2);

        System.out.println(sum(num1, num2));
    }

    public static Node<Integer> sum(Node<Integer> num1, Node<Integer> num2) {
        Node<Integer> dummyNode = new Node<>(0, null);
        Node<Integer> node = dummyNode;

        Integer in = 0;
        while (num1 != null || num2 != null) {
            if (num1 != null && num2 != null) {
                int value = num1.getValue() + num2.getValue() + in;
                if (value > 9) {
                    in = 1;
                    value = value - 10;
                } else {
                    in = 0;
                }

                node.setNext(new Node<>(value, null));
                node = node.getNext();
                num1 = num1.getNext();
                num2 = num2.getNext();
                continue;
            }

            if (num1 != null) {
                int value = num1.getValue() + in;
                if (value > 9) {
                    in = 1;
                    value = value - 10;
                } else {
                    in = 0;
                }

                node.setNext(new Node<>(value, null));
                node = node.getNext();
                num1 = num1.getNext();
                continue;
            }

            int value = num2.getValue() + in;
            if (value > 9) {
                in = 1;
                value = value - 10;
            } else {
                in = 0;
            }

            node.setNext(new Node<>(value, null));
            node = node.getNext();
            num2 = num2.getNext();
        }

        if (in == 1) {
            node.setNext(new Node<>(1, null));
        }

        return dummyNode.getNext();
    }
}
