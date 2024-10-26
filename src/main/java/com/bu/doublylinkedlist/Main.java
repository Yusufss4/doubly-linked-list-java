package com.bu.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Size: " + list.size());
        System.out.println("List: " + list);

        list.remove(2);
        list.remove(1);

        System.out.println("Size: " + list.size());
        System.out.println("List: " + list);

        list.add(4);
        list.add(5);
        list.reverseAll();

        System.out.println("Size: " + list.size());
        System.out.println("List: " + list);

        list.removeByIndex(0);
        list.removeByIndex(1);

        System.out.println("Size: " + list.size());
        System.out.println("List: " + list);
    }

}
