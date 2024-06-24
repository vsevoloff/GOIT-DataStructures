package CustomStructures;

import CustomExceptions.IndexException;

public class CustomStack<T>{
    private Node<T> head = new Node<>();
    private Node<T> tail = new Node<>();

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
            throw new IndexException("Wrong index!");
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
        return tail.getElement();
    }

    public T pop() {
        if (size == 0) {
            return null;
        }

        T element = tail.getElement();
        if (size == 1) {
            head = null;
            tail = null;
        }

        else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        size--;
        return element;
    }

    public int size() {
        return size;
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

    private static class Node<T> {
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
}
