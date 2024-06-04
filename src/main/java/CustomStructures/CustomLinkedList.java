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

    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < size; i++) {
            result.append(current.getElement().toString());
            result.append(" ");
            current = current.getNext();
        }

        return  result.toString();
    }

}
