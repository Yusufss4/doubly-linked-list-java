package com.bu.doublylinkedlist;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals(2, list.size());
        assertEquals("[1, 3]", list.toString());
    }

    @Test
    public void testRemoveNonExistentElement() {
        list.add(1);
        list.add(2);
        list.remove(3); // Element 3 does not exist
        assertEquals(2, list.size());
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    public void testRemoveByIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeByIndex(1);
        assertEquals(2, list.size());
        assertEquals("[1, 3]", list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByInvalidIndex() {
        list.add(1);
        list.removeByIndex(1); // Index 1 is invalid since size is 1
    }

    @Test
    public void testCompareEqualLists() {
        DoublyLinkedList<Integer> otherList = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        otherList.add(1);
        otherList.add(2);
        assertTrue(list.compare(otherList));
    }

    @Test
    public void testCompareUnequalLists() {
        DoublyLinkedList<Integer> otherList = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        otherList.add(1);
        otherList.add(3);
        assertFalse(list.compare(otherList));
    }

    @Test
    public void testCompareDifferentSizes() {
        DoublyLinkedList<Integer> otherList = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        otherList.add(1);
        assertFalse(list.compare(otherList));
    }

    @Test
    public void testToStringEmptyList() {
        assertEquals("[]", list.toString());
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

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

    @Test
    public void testReverseEmptyList() {
        list.reverseAll();
        assertEquals("[]", list.toString());
    }

    @Test
    public void testReverseSingleElement() {
        list.add(1);
        list.reverseAll();
        assertEquals("[1]", list.toString());
    }
}
