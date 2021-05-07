package test.aufgabe01;

import at.fhmc.Aufgabe01.DoubleLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    @Test
    void addElementsFrontAndBack_getTheSize_Clear() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.prepend(3);
        doubleLinkedList.append(7);
        doubleLinkedList.prepend(5);
        doubleLinkedList.append(9);

        assertEquals( 7,doubleLinkedList.get(2));
        assertEquals(5, doubleLinkedList.get(0));
        assertEquals(Integer.MIN_VALUE, doubleLinkedList.get(4));

        assertEquals(4, doubleLinkedList.size());

        doubleLinkedList.clear();
        assertEquals(0, doubleLinkedList.size());
    }

    @Test
    void addElementsFront_peekFront_thenPop_size() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.prepend(3);
        doubleLinkedList.prepend(5);
        doubleLinkedList.prepend(7);

        assertEquals(7, doubleLinkedList.peekFront());

        doubleLinkedList.popFront();

        assertEquals(5, doubleLinkedList.peekFront());
        assertEquals(2, doubleLinkedList.size());

        doubleLinkedList.popFront();
        assertEquals(3, doubleLinkedList.popFront());
        assertEquals(Integer.MIN_VALUE, doubleLinkedList.popFront());
    }

    @Test
    void addElementsBack_peekBack_thenPop_size() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.append(3);
        doubleLinkedList.append(5);
        doubleLinkedList.append(7);

        assertEquals(7, doubleLinkedList.peekBack());

        doubleLinkedList.popBack();

        assertEquals(5, doubleLinkedList.peekBack());
        assertEquals(2, doubleLinkedList.size());

        assertEquals(5, doubleLinkedList.popBack());
        doubleLinkedList.popBack();
        assertEquals(Integer.MIN_VALUE, doubleLinkedList.popBack());
    }

    @Test
    void addElements_reverse() {
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
}
