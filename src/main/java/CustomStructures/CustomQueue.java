package CustomStructures;

public class CustomQueue<T> {
    private Node<T> head = new Node<>();
    private Node<T> tail = new Node<>();

    private int size;

    public void add(T element) {

        Node<T> newNode = new Node<>();
        newNode.setElement(element);

        if (head.getElement() == null) {
            head = newNode;
            tail = newNode;
        } else {
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
            current = current.getNext();
        }

        head = null;
        tail = null;
        size = 0;
    }

    public T peek() {
        return head.getElement();
    }

    public T poll() {
        T elemnt = head.getElement();
        head = head.getNext();
        head.setPrevious(null);
        size--;
        return elemnt;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {

        if (size == 0) {
            return "Queue is empty!";
        }

        Node<T> current = head;
        StringBuilder result = new StringBuilder();

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

