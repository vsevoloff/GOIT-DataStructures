package CustomStructures;


import CustomExceptions.IndexException;

import java.util.Arrays;

public class CustomArrayList<T>  {

    private int size = 0;
    private T[] elements;

    public CustomArrayList(T[] elemnets) {
        this.size = elemnets.length;
        this.elements = Arrays.copyOf(elemnets, elemnets.length);
    }

    public CustomArrayList() {
        elements = (T[]) new Object[size];
    }

    public void add(T element) {
        T[] newElements = (T[]) new Object[++size];

        for(int i = 0; i < elements.length;i++) {
            newElements[i] = elements[i];
        }

        newElements[size-1] = element;
        elements = newElements;
    }

    public void remove(int index) {

            if (index < 0 || index >= size) {
                throw new IndexException("Wrong index!");
            }

        T[] newElements = (T[]) new Object[--size];

        int counter = 0;
        for (int i = 0; i < elements.length; i ++) {
            if (i!=index) {
                newElements[counter++] = elements[i];
            }
        }
        elements = newElements;
    }

    public void clear() {
        size = 0;
        elements = (T[]) new Object[size];
    }

    public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexException("Wrong index!");
            }
        return elements[index];
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "List is empty!";
        }
        StringBuilder result = new StringBuilder();

        for (T element : elements) {
            result.append(element.toString()).append(" ");
        }
        return  result.toString();

    }


}
