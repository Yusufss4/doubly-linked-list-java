package com.bu.doublylinkedlist;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }

        size++;
    }

    public void remove(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                removeNode(current);
                return;
            }

            current = current.getNext();
        }
    }

    public void removeByIndex(int index) {
        Node<T> current = getNodeAtIndex(index);
        removeNode(current);
    }

    public boolean compare(DoublyLinkedList<T> list) {
        if (size != list.size()) {
            return false;
        }

        Node<T> current = head;
        Node<T> otherCurrent = list.head;

        while (current != null) {
            if (!current.getData().equals(otherCurrent.getData())) {
                return false;
            }

            current = current.getNext();
            otherCurrent = otherCurrent.getNext();
        }

        return true;
    }

    public void reverseAll() {
        Node<T> current = head;
        while (current != null) {
            Node<T> temp = current.getNext();
            current.setNext(current.getPrev());
            current.setPrev(temp);
            current = temp;
        }

        Node<T> temp = head;
        head = tail;
        tail = temp;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void removeNode(Node<T> node) {
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext();
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev();
        }

        size--;
    }

    private Node<T> getNodeAtIndex(int index) {
        checkElementIndex(index);

        Node<T> current;

        // If the index is closer to the head, start from the head else start from the
        // tail
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }

        return current;
    }
}