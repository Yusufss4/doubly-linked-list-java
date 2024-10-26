/**
 * A generic implementation of a doubly linked list.
 *
 * @param <T> the type of elements held in this list
 */
class DoublyLinkedList<T> {
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
}

/**
 * Represents a node in a doubly linked list.
 *
 * @param <T> the type of data stored in the node
 */
class Node<T> {
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

/**
 * The main class to demonstrate the functionality of the DoublyLinkedList.
 */
public class Main {
    public static void main(String[] args) {

        // Testing normal operation of the DoublyLinkedList
        System.out.println("Single Element List");
        DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();

        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        intList.add(8);
        intList.remove(7);
        intList.remove(8);

        printBeforeReverse(intList);
        intList.reverseAll();
        printAfterReverse(intList);

        // Testing two elements in the DoublyLinkedList
        System.out.println("");
        System.out.println("Single Element List");
        DoublyLinkedList<String> stringList = new DoublyLinkedList<>();
        stringList.add("a");
        stringList.add("b");

        printBeforeReverse(stringList);
        stringList.reverseAll();
        printAfterReverse(stringList);

        // Testing empty list
        System.out.println("");
        System.out.println("Double Element List");
        DoublyLinkedList<String> emptyList = new DoublyLinkedList<>();
        printBeforeReverse(emptyList);
        emptyList.reverseAll();
        printAfterReverse(emptyList);

        // Testing single element list
        System.out.println("");
        System.out.println("Single Element List");
        DoublyLinkedList<Integer> singleElementList = new DoublyLinkedList<>();
        singleElementList.add(1);
        printBeforeReverse(singleElementList);
        singleElementList.reverseAll();
        printAfterReverse(singleElementList);

    }

    private static <T> void printBeforeReverse(DoublyLinkedList<T> list) {
        System.out.println("Before Reversing");
        System.out.println("Size: " + list.size());
        System.out.println("List: " + list);
    }

    private static <T> void printAfterReverse(DoublyLinkedList<T> list) {
        System.out.println("After Reversing");
        System.out.println("Size: " + list.size());
        System.out.println("List: " + list);
    }
}
