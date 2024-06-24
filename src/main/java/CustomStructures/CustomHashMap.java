package CustomStructures;

public class CustomHashMap<K,V> {

    private Node<K,V> head = new Node<>();
    private Node <K,V> tail = new Node<>();
    private CustomArrayList<K> keys = new CustomArrayList<>();

    private int size;

    public void put(K key, V value) {
        Node<K, V> newElement = new Node<>();
        newElement.setValue(key, value);

        if (isKeyExist(key)) {

            Node<K, V> current = head;
            int indexOfKey = indexOfKey(key);
            for(int i = 0; i < indexOfKey; i++) {
                current = current.next;
            }
            current.setValue(key, value);

        } else {
            if (head.getValue() == null) {
                head = newElement;
                tail = head;
            } else {
                tail.setNext(newElement);
                tail = newElement;
            }
            size++;
        }
        keys.add(key);
    }

    public void remove(K key) {
        Node<K,V> current = head;
        int indexOfKey = indexOfKey(key);

        if (indexOfKey == -1) {
            System.out.println("Key not found!");
            return;
        }
        else if (indexOfKey == 0) {
            head = head.next;
        }
        else if (indexOfKey == size) {
            tail = tail.next;
        }
        else {
            for (int i = 0; i < indexOfKey - 1; i++) {
                current = current.next;
            }
            current.setNext(current.next.next);
        }
        size--;
    }

    public void clear() {
        Node<K,V> current = head;
        Node<K,V> nextForCurrent = head;

        for (int i = 0; i < size; i++) {
            nextForCurrent = current.next;
            current.setNext(null);
            current = nextForCurrent;
        }
        size = 0;
    }

    public V get(K key) {
        if(!isKeyExist(key)) {
            System.out.println("Key not found");
            return null;
        }

        Node<K,V> current = head;


        for (int i = 0; i < size; i++) {
             if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private boolean isKeyExist(K key){
        for (int i = 0; i < size; i++) {
            if ((key == null && keys.get(i) == null) || (key != null && key.equals(keys.get(i)))) {
                return true;
            }
        }
        return false;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == null && keys.get(i) == null) || (key != null && key.equals(keys.get(i)))) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {

        if (size == 0) {
            return "HashMap is empty!";
        }

        StringBuilder result = new StringBuilder();
        Node<K, V> current = head;

        for (int i = 0; i < size; i++) {

            result.append("Key: ");
            if (current.key == null) {
                result.append("null");
            }
            else {
                result.append(current.key.toString());
            }

            result.append(" | Value: (").append(current.value.getClass().getSimpleName()).append(") ")
                    .append(current.value.toString()).append('\n');
            current = current.next;
        }

        return result.toString();
    }


    private static class Node<K,V> {
        private K key;
        private V value;
        private Node<K,V> next;

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public void setValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

    }
}
