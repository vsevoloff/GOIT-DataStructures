package CustomStructures;

import CustomExceptions.IndexException;
import lombok.Getter;

public class CustomStack<T>{
    private Node<T> head = new Node<>();
    private Node<T> tail = new Node<>();

    @Getter
    private int size;

    public void push(T element) {
        Node<T> newElement = new Node<>();
        newElement.setElement(element);
        size++;

        if (head.getElement() == null) {
            head = newElement;
            tail = newElement;
        }
        else {
            tail.setNext(newElement);
            newElement.setPrevious(tail);
            tail = newElement;
        }
    }

    public void remove(int index)  {

        if (index < 0 || index >= size) {
            System.out.println("Wrong index!");
            return;
        }

        Node<T> current = head;

        if (index == 0) {
            if (head.getNext() == null) {
                head = null;
                tail = null;

            }
            else {
                head = head.getNext();
            }
        } else if (index == size - 1){
            tail = tail.getPrevious();
        }
        else {

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            Node<T> NextForCurrent = current.getNext();
            Node<T> PreviousForCurrent = current.getPrevious();
            current.setElement(null);

            NextForCurrent.setPrevious(PreviousForCurrent);
            PreviousForCurrent.setNext(NextForCurrent);
        }
        size--;
    }

    public void clear() {
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
            current.setPrevious(null);
            current = current.getNext();
        }
        size = 0;
        tail = null;
        head = null;
    }

    public T peek() {
        return head.getElement();
    }

    public T pop() {
        if (size == 0) {
            return null;
        }

        T element = head.getElement();
        if (size == 1) {
            head = null;
        }

        else {
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
        return element;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Stack is empty!";
        }

        StringBuilder result = new StringBuilder();
        Node<T> current = head;

        for (int i = 0; i < size; i++) {
             result.append(current.getElement().toString()).append(" ");
            current = current.getNext();
        }

        return result.toString();
    }

}
