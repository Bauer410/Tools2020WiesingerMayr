package at.fhmc.Aufgabe02;

public class Node {
    /** Ref to the next elem in the list, or null if it is the last */
    public Node next;

    /** Ref to the prev elem in the list, or null if it is the first */
    public Node prev;

    /** Holds the actual data */
    public int val;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}