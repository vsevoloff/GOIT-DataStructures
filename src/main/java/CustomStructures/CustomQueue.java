package CustomStructures;

import lombok.Getter;

import java.util.Arrays;

public class CustomQueue<T>{
    private Node<T> head = new Node<>();
    private Node<T> tail = new Node<>();

    @Getter
    private int size;

    public void add(T element) {

        Node<T> newNode = new Node<>();
        newNode.setElement(element);

        if (head.getElement() == null)
        {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            current.setPrevious(null);
            current.setElement(null);
            current = current.getNext();
        }

        head = null;
        tail = null;
        size = 0;
    }

    public T peek() {
        return head.getElement();
    }

    public T pool() {
        T elemnt = head.getElement();
        head.setElement(null);
        head = head.getNext();
        head.setPrevious(null);
        size--;
        return elemnt;
    }

    @Override
    public String toString() {

        if (size == 0) {
            return "Queue is empty!";
        }

        Node<T> current = head;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++){
            result.append(current.getElement().toString()).append(" ");
            current = current.getNext();
        }

        return result.toString();
    }
}
