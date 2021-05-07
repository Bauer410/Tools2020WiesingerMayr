package at.fhmc.Aufgabe03;

public class ListNode {
    /** Ref to the next element in the list, or null if it is the last */
    public ListNode next;

    /** Ref to the prev elem in the list, or null if it is the first */
    public ListNode prev;

    /** Holds another list. */
    public DoubleLinkedList list;
}