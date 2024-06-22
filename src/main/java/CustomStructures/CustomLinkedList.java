package CustomStructures;

import CustomExceptions.IndexException;
import lombok.Getter;


public class CustomLinkedList<T> {
    private Node<T> tail = new Node<>();
    private Node<T> head = new Node<>();

    @Getter
    private int size;

    public void add(T element) {
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

    public void remove(int index) {

            if(index < 0 || index > size-1) {
                System.out.println("Wrong index!");
                return;
            }

        Node<T> current = head;

        if(index == 0) {
            if (head.getNext() == null) {
                head = null;
                tail = null;
                size--;
                return;
            }
            head = head.getNext();
        }
        else if(index == size-1) {
            tail = tail.getPrevious();
        }
        else {

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            Node<T> nextForCurrent = current.getNext();
            Node<T> previousForCurrent = current.getPrevious();

            previousForCurrent.setNext(nextForCurrent);
            nextForCurrent.setPrevious(previousForCurrent);
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

    public T get(int index) {

        if (index < 0 || index >= size) {
            System.out.println("Wrong index!");
            return null;
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getElement();

    }



    @Override
    public String toString() {

        if (size == 0) {
            return "List is empty!";
        }

        Node<T> current = head;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < size; i++) {
            result.append(current.getElement().toString()).append(" ");
            current = current.getNext();
        }

        return  result.toString();
    }

}
