package CustomStructures;


import CustomExceptions.IndexException;
import lombok.Getter;

import java.util.Arrays;

public class CustomArrayList<T>  {

    @Getter
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

        try {
            if (index < 0 || index >= size) {
                throw new IndexException("Wrong index!");
            }
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
            return;
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
        try {
            if (index < 0 || index >= size) {
                throw new IndexException("Wrong index!");
            }
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return elements[index];
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "List is empty!";
        }
        StringBuilder result = new StringBuilder();

        for (T element : elements) {
            result.append(element.toString());
        }
        return  result.toString();

    }


}
