package org.example;


import CustomStructures.CustomArrayList;
import CustomStructures.CustomLinkedList;
import CustomStructures.CustomStack;

public class Main {
    public static void main(String[] args) {

        CustomStack<Integer> stack = new CustomStack<>();
        CustomLinkedList<Integer> list = new CustomLinkedList<>();


        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.pop();


        System.out.println(stack);




    }


}