package others.common;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/11
 * @content:
 */
public class Node<T> {

    private T value;

    private Node<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public static <T> Node<T> buildList(ArrayList<T> list) {
        if (list == null || list.size() == 0){
            return null;
        }

        Node<T> node = new Node<>(list.get(list.size() - 1), null);

        for(int i = list.size() - 2; i >=0; i-- ){
            node = new Node<>(list.get(i), node);
        }

        return node;
    }

    @Override
    public String toString() {
        Node<T> node = this;
        StringBuilder builder = new StringBuilder();
        while(node != null){
            builder.append(node.getValue().toString()).append(",");
            node = node.getNext();
        }

        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }
}
