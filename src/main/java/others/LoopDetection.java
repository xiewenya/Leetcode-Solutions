package others;

import others.common.Node;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/11
 * @content:
 */
public class LoopDetection {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(2, null);
        Node<Integer> tail = node;
        node = new Node<>(4, node);
        node = new Node<>(3, node);
        node = new Node<>(1, node);
        tail.setNext(node);
        node = new Node<>(5, node);
        node = new Node<>(6, node);
        node = new Node<>(3, node);

        Node<Integer> result = loop(node);
        System.out.println(result == null ? null : result.getValue());
    }

    public static Node<Integer> loop(Node<Integer> node){
        if (node == null){
            return null;
        }

        Node<Integer> slow = node;
        Node<Integer> fast = null;
        while (slow != fast){
            if (fast == null){
                fast = slow;
            }

            if (fast.getNext() == null || fast.getNext().getNext() == null){
                return null;
            }

            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        slow = node;

        while (slow != fast){
            slow = slow.getNext();
            fast = fast.getNext();
        }


        return fast;

    }
}
