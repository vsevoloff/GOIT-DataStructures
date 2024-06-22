package org.example;


import CustomStructures.*;
import Entities.Student;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // STUDENTS FOR TESTING
        Student student1 = new Student("Vasya", "01", 20);
        Student student2 = new Student("Petya", "02", 20);
        Student student3 = new Student("Masha", "03", 20);
        Student student4 = new Student("Natasha", "04", 20);

        // TESTS FOR ARRAYLIST
        CustomArrayList<Student> arrayList = new CustomArrayList<>();
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);
        arrayList.add(student4);

        // DATA
        System.out.println("DATA: ");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

        System.out.println("-------------------------------------");
        System.out.println("ARRAY LIST: ");
        System.out.print("Get: ");
        System.out.println(arrayList.get(2));
        System.out.println("Size: " + arrayList.getSize());
        arrayList.remove(2);
        System.out.println("Delete element: ");
        System.out.println(arrayList);

        System.out.print("Clear: ");
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println("-------------------------------------");


        // TEST FOR LINKED LIST
        CustomLinkedList<Student> linkedList = new CustomLinkedList<>();
        System.out.println("LINKED LIST: ");
        linkedList.add(student1);
        linkedList.add(student2);
        linkedList.add(student3);
        linkedList.add(student4);

        System.out.print("Get: ");
        System.out.println(linkedList.get(2));
        System.out.println("Size: " + linkedList.getSize());
        linkedList.remove(2);
        System.out.println("Delete element: ");
        System.out.println(linkedList);

        System.out.print("Clear: ");
        linkedList.clear();
        System.out.println(linkedList);
        System.out.println("-------------------------------------");

        // STACK
        CustomStack<Student> stack = new CustomStack<>();
        stack.push(student1);
        stack.push(student2);
        stack.push(student3);
        stack.push(student4);

        System.out.println("STACK: ");
        System.out.println("SIZE: " + stack.getSize());
        System.out.println("PEEK: "+ stack.peek());
        System.out.println("POP: " + stack.pop());
        System.out.print("Clear: ");
        stack.clear();
        System.out.println(stack);
        System.out.println("-------------------------------------");
        CustomQueue<Student> queue = new CustomQueue<>();
        queue.add(student1);
        queue.add(student2);
        queue.add(student3);
        queue.add(student4);

        // QUEUE
        System.out.println("QUEUE:");
        System.out.println("SIZE: " + queue.getSize());
        System.out.println("POOL: " + queue.pool());
        System.out.println("PEEK: " + queue.peek());
        System.out.println("CLEAR: "); queue.clear();
        System.out.println(queue);

        System.out.println("-------------------------------------");
        // HASH MAP
        System.out.println("HASH MAP: ");
        CustomHashMap<Integer, Student> map = new CustomHashMap<>();
        map.put(1,student1);
        map.put(2,student2);
        map.put(3,student3);
        map.put(4,student4);
        System.out.println(map);
        System.out.println("Size: " + map.getSize());
        System.out.println("Get #2: " + map.get(2));
        System.out.println("Remove #2: ");
        map.remove(2);
        System.out.println(map);

    }


}