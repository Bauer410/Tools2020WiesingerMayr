package test.aufgabe03;

import at.fhmc.Aufgabe03.DoubleLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    @Test
    void theUltimativeLinkedListTest() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleLinkedList addedList = new DoubleLinkedList();
        addedList.append(5);
        addedList.append(8);

        doubleLinkedList.prependRecursive(addedList);

        DoubleLinkedList anotherAddedList = new DoubleLinkedList();
        anotherAddedList.append(10);
        anotherAddedList.append(1);

        doubleLinkedList.prependRecursive(anotherAddedList);

        assertEquals(6, doubleLinkedList.elements());
        assertEquals(true, doubleLinkedList.search(10));

        doubleLinkedList.popFront();
        assertEquals(false, doubleLinkedList.search(10));

        doubleLinkedList.popFront();
        assertEquals(3, doubleLinkedList.elements());
    }

    @Test
    void addListToDoubleLinkedListBeginning_Works() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleLinkedList addedList = new DoubleLinkedList();
        addedList.append(5);
        addedList.append(8);

        doubleLinkedList.prependRecursive(addedList);

        doubleLinkedList.prepend(4);

        assertNotEquals(4, doubleLinkedList.peekFront());
        assertNotEquals(null, doubleLinkedList.getRecursiveHead());
        assertEquals(null, doubleLinkedList.getHead());
    }

    @Test
    void addListToDoubleLinkedListBeginning_Remove_AddValueToBeginning() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleLinkedList addedList = new DoubleLinkedList();
        addedList.append(5);
        addedList.append(8);

        doubleLinkedList.prependRecursive(addedList);

        assertEquals(5, doubleLinkedList.popFront());
        assertEquals(8, doubleLinkedList.popFront());

        doubleLinkedList.append(3);
        assertEquals(3, doubleLinkedList.peekFront());
    }

    @Test
    void addListToDoubleLinkedListEnd_Works() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleLinkedList addedList = new DoubleLinkedList();
        addedList.append(5);
        addedList.append(8);

        doubleLinkedList.appendRecursive(addedList);

        assertNotEquals(null, doubleLinkedList.getRecursiveTail());
        assertEquals(null, doubleLinkedList.getTail());
    }

    @Test
    void addListToDoubleLinkedListEnd_DoesNotWork() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.append(3);

        DoubleLinkedList addedList = new DoubleLinkedList();
        addedList.append(5);
        addedList.append(8);

        doubleLinkedList.appendRecursive(addedList);

        assertEquals(null, doubleLinkedList.getRecursiveTail());
        assertNotEquals(null, doubleLinkedList.getTail());
    }

    @Test
    void peekAtElementAndPopElementAtTheBeginning() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleLinkedList addedList = new DoubleLinkedList();
        addedList.append(5);
        addedList.append(8);

        doubleLinkedList.prependRecursive(addedList);

        assertEquals(5,  doubleLinkedList.peekFront());
        assertEquals(5, doubleLinkedList.popFront());
        assertEquals(8, doubleLinkedList.peekFront());
    }

    @Test
    void peekAtElementAndPopElementAtTheEnd() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleLinkedList addedList = new DoubleLinkedList();
        addedList.append(5);
        addedList.append(8);

        doubleLinkedList.prependRecursive(addedList);

        assertEquals(8,  doubleLinkedList.peekBack());
        assertEquals(8, doubleLinkedList.popBack());
        assertEquals(5, doubleLinkedList.peekBack());
    }

    @Test
    void reverseOrderOfList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.append(3);
        doubleLinkedList.append(5);
        doubleLinkedList.append(7);
        doubleLinkedList.append(9);

        assertEquals(9, doubleLinkedList.peekBack());

        doubleLinkedList.reverse();

        assertEquals(9, doubleLinkedList.peekFront());
        assertEquals(3, doubleLinkedList.peekBack());
    }

    @Test
    void searchForElementInLinkedList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleLinkedList addedList = new DoubleLinkedList();
        addedList.append(5);
        addedList.append(8);

        doubleLinkedList.prependRecursive(addedList);

        DoubleLinkedList addedList2 = new DoubleLinkedList();
        addedList2.append(12);
        addedList2.append(10);

        doubleLinkedList.prependRecursive(addedList2);

        assertEquals(6, doubleLinkedList.elements());

        assertEquals(true, doubleLinkedList.search(12));
        assertEquals(false, doubleLinkedList.search(6));
    }
}
