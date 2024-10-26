package com.bu.doublylinkedlist;

/**
 * Represents a node in a doubly linked list.
 *
 * @param <T> the type of data stored in the node
 */
public class Node<T> {
    /**
     * The data stored in this node.
     */
    private T data;

    /**
     * Reference to the previous node in the list.
     */
    private Node<T> prev;

    /**
     * Reference to the next node in the list.
     */
    private Node<T> next;

    /**
     * Constructs a new node with the specified data.
     *
     * @param data the data to store in this node
     */
    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    /**
     * Returns the data stored in this node.
     *
     * @return the data stored in this node
     */
    public T getData() {
        return data;
    }

    /**
     * Returns the previous node in the list.
     *
     * @return the previous node
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the data stored in this node.
     *
     * @param data the data to store in this node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param prev the node to set as previous
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the node to set as next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
