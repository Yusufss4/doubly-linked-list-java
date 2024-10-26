package com.bu.doublylinkedlist;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the {@link DoublyLinkedList} class.
 */
public class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> list;

    /**
     * Sets up a new empty list before each test.
     */
    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    /**
     * Tests adding elements to the list.
     */
    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals("[1, 2, 3]", list.toString());
    }

    /**
     * Tests removing an existing element from the list.
     */
    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals(2, list.size());
        assertEquals("[1, 3]", list.toString());
    }

    /**
     * Tests removing a non-existent element from the list.
     */
    @Test
    public void testRemoveNonExistentElement() {
        list.add(1);
        list.add(2);
        list.remove(3); // Element 3 does not exist
        assertEquals(2, list.size());
        assertEquals("[1, 2]", list.toString());
    }

    /**
     * Tests removing an element by index from the list.
     */
    @Test
    public void testRemoveByIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeByIndex(1);
        assertEquals(2, list.size());
        assertEquals("[1, 3]", list.toString());
    }

    /**
     * Tests removing an element by an invalid index, expecting an exception.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByInvalidIndex() {
        list.add(1);
        list.removeByIndex(1); // Index 1 is invalid since size is 1
    }

    /**
     * Tests comparing two equal lists.
     */
    @Test
    public void testCompareEqualLists() {
        DoublyLinkedList<Integer> otherList = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        otherList.add(1);
        otherList.add(2);
        assertTrue(list.compare(otherList));
    }

    /**
     * Tests comparing two lists with different elements.
     */
    @Test
    public void testCompareUnequalLists() {
        DoublyLinkedList<Integer> otherList = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        otherList.add(1);
        otherList.add(3);
        assertFalse(list.compare(otherList));
    }

    /**
     * Tests comparing two lists of different sizes.
     */
    @Test
    public void testCompareDifferentSizes() {
        DoublyLinkedList<Integer> otherList = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        otherList.add(1);
        assertFalse(list.compare(otherList));
    }

    /**
     * Tests the toString method on an empty list.
     */
    @Test
    public void testToStringEmptyList() {
        assertEquals("[]", list.toString());
    }

    /**
     * Tests the size method of the list.
     */
    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    /**
     * Tests reversing the elements of the list.
     */
    @Test
    public void testReverse() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.reverseAll();
        assertEquals("[3, 2, 1]", list.toString());

        // Reverse again to check if it returns to original
        list.reverseAll();
        assertEquals("[1, 2, 3]", list.toString());
    }

    /**
     * Tests reversing an empty list.
     */
    @Test
    public void testReverseEmptyList() {
        list.reverseAll();
        assertEquals("[]", list.toString());
    }

    /**
     * Tests reversing a list with a single element.
     */
    @Test
    public void testReverseSingleElement() {
        list.add(1);
        list.reverseAll();
        assertEquals("[1]", list.toString());
    }
}
