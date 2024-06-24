package CustomStructures;

import CustomExceptions.IndexException;


public class CustomLinkedList<T> {
    private Node<T> tail = new Node<>();
    private Node<T> head = new Node<>();

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
                throw new IndexException("Wrong Index!");
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
            throw new IndexException("Wrong index!");
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getElement();

    }

    public int size() { return  size; }

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
