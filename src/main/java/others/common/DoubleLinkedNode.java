package others.common;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/11
 * @content:
 */
public class DoubleLinkedNode<T> extends Node<T> {

    DoubleLinkedNode<T> prev;

    public DoubleLinkedNode(T value, Node<T> next, DoubleLinkedNode<T> prev) {
        super(value, next);
        this.prev = prev;
    }

    public DoubleLinkedNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedNode<T> prev) {
        this.prev = prev;
    }
}
