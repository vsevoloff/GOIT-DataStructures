package CustomStructures;

import lombok.Data;

public class Node<T> {
    private T element;
    private Node<T> next;
    private Node<T> previous;

    public void setElement(T element) {
        this.element = element;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public T getElement() {
        return element;
    }
}
