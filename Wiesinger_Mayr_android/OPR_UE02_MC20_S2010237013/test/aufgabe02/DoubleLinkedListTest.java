package test.aufgabe02;

import at.fhmc.Aufgabe02.DoubleLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    @Test
    void constructorCopyLinkedList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.prepend(3);
        doubleLinkedList.prepend(5);

        DoubleLinkedList originalEmptyLinkedList = new DoubleLinkedList(doubleLinkedList);
        assertEquals(5, originalEmptyLinkedList.peekFront());
        assertEquals(3, originalEmptyLinkedList.peekBack());
    }

    @Test
    void prependLinkedList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.prepend(3);
        doubleLinkedList.prepend(5);

        DoubleLinkedList toPrependLinkedList = new DoubleLinkedList();
        toPrependLinkedList.prepend(13);
        toPrependLinkedList.prepend(2);

        doubleLinkedList.prepend(toPrependLinkedList);

        assertEquals(2, doubleLinkedList.peekFront());
        assertNotEquals(5, doubleLinkedList.peekFront());
        assertEquals(3 , doubleLinkedList.peekBack());
        assertEquals(4, doubleLinkedList.size());
    }

    @Test
    void appendLinkedList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.append(3);
        doubleLinkedList.append(5);

        DoubleLinkedList toAppendLinkedList = new DoubleLinkedList();
        toAppendLinkedList.append(13);
        toAppendLinkedList.append(2);

        doubleLinkedList.append(toAppendLinkedList);

        assertNotEquals(5, doubleLinkedList.peekBack());
        assertEquals(3 , doubleLinkedList.peekFront());
        assertEquals(2 , doubleLinkedList.peekBack());
        assertEquals(4, doubleLinkedList.size());
    }

    @Test
    void clonesLinkedList_CheckIfEqual() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.append(3);
        doubleLinkedList.append(5);
        doubleLinkedList.prepend(12);
        doubleLinkedList.prepend(11);

        String actual = doubleLinkedList.toString();
        String expected="11->12->3->5";
        assertEquals(expected, actual);

        DoubleLinkedList clonedList = doubleLinkedList.clone();
        assertEquals(11, clonedList.peekFront());
        assertEquals(5, clonedList.peekBack());
        assertEquals(true, doubleLinkedList.equals(clonedList));
    }

    @Test
    void checkIfEqual() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.append(3);
        doubleLinkedList.append(5);

        DoubleLinkedList anotherLinkedList = new DoubleLinkedList();
        anotherLinkedList.append(3);

        assertEquals(false, doubleLinkedList.equals(anotherLinkedList));

        anotherLinkedList.append(12);
        assertEquals(false, doubleLinkedList.equals(anotherLinkedList));

        anotherLinkedList.popBack();
        anotherLinkedList.append(5);
        assertEquals(true, doubleLinkedList.equals(anotherLinkedList));
    }

    @Test
    void searchForElements() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.append(3);
        doubleLinkedList.append(5);
        doubleLinkedList.append(12);

        assertEquals(true, doubleLinkedList.search(12));
        assertEquals(false, doubleLinkedList.search(7));
    }
}
