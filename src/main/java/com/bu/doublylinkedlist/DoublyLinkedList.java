package com.bu.doublylinkedlist;

/**
 * A generic implementation of a doubly linked list.
 *
 * @param <T> the type of elements held in this list
 */
public class DoublyLinkedList<T> {
    /**
     * The head (first node) of the list.
     */
    private Node<T> head;

    /**
     * The tail (last node) of the list.
     */
    private Node<T> tail;

    /**
     * The number of elements in the list.
     */
    private int size;

    /**
     * Constructs an empty doubly linked list.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param data the element to be added
     */
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

    /**
     * Removes the first occurrence of the specified element from the list, if it is
     * present.
     *
     * @param data the element to be removed
     */
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

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
     *                                   || index &gt;= size())
     */
    public void removeByIndex(int index) {
        Node<T> current = getNodeAtIndex(index);
        removeNode(current);
    }

    /**
     * Compares the specified list with this list for equality.
     *
     * @param list the list to be compared for equality with this list
     * @return true if the specified list is equal to this list
     */
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

    /**
     * Reverses the order of the elements in the list.
     */
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

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
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

    /**
     * Checks if the index is within the bounds of the list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the specified node from the list.
     *
     * @param node the node to remove
     */
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

    /**
     * Returns the node at the specified index.
     *
     * @param index the index of the node to return
     * @return the node at the specified index
     */
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
