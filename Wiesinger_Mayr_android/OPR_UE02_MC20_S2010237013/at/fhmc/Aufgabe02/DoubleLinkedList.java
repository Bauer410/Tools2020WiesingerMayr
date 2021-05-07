package at.fhmc.Aufgabe02;

import at.fhmc.Aufgabe01.Node;

public class DoubleLinkedList {
    /** Pointer to the first and last element of the list */
    private Node head, tail;
    private int size;

    /** Constructor initializes an empty list.*/
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Copy constructor initializes list with another list.
     * This constructor must COPY all elements of the other list.
     * The elements of the other list must NOT be changed!
     */
    public DoubleLinkedList(DoubleLinkedList other) {
        head = other.head;
        tail = other.tail;
        size = other.size;
    }

    /** Clears all elements from the linked list */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Adds an element at the front of the linked list.*/
    public void prepend(int val) {
        if(head != null) {
            Node node = head;
            head = new Node();

            node.prev = head;
            head.next = node;
            head.val = val;
        }
        else if(head == null) {

            head = new Node();
            head.val = val;
            tail = head;
        }

        size++;
    }

    /** Adds an element at the back of the linked list. */
    public void append(int val) {
         if(tail != null) {
            Node node = tail;
            tail = new Node();
            node.next = tail;

            tail.prev = node;
            tail.val = val;
        } else if(tail == null) {

            tail = new Node();
            tail.val = val;
            head = tail;
        }

        size++;
    }

    /** Returns the element at position ‘index’. Returns
     * Integer.MIN_VALUE if ‘index’ is invalid. */
    public int get(int index) {
        if(index >= size) {
            return Integer.MIN_VALUE;
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.val;
    }

    /** Removes and returns the front element of the linked list. Returns
     *Integer.MIN_VALUE if empty */
    public int popFront() {
        if(head == null) {
            return Integer.MIN_VALUE;
        }

        Node node = head;
        head = node.next;

        size--;

        return node.val;
    }

    /** Returns the front element of the list without removing it.
     * Returns Integer.MIN_VALUE if empty */
    public int peekFront() {
        if(head == null) {
            return Integer.MIN_VALUE;
        }

        return head.val;
    }

    /** Removes and returns the element from the back of the linked list.
     * Returns Integer.MIN_VALUE if empty */
    public int popBack() {
        if(tail == null) {
            return Integer.MIN_VALUE;
        }

        Node node = tail;
        tail = node.prev;

        size--;

        return node.val;
    }

    /** Returns the element at the back of the list without removing it.
     * Returns Integer.MIN_VALUE if empty */
    public int peekBack() {
        if(tail == null) {
            return Integer.MIN_VALUE;
        }

        return tail.val;
    }

    /** Returns the number of elements in the double linked list */
    public int size() {
        return size;
    }

    /** Reverses the order of all elements in the list. “He who is first,
     * shall be last!” */
    public void reverse() {
        Node headNode = head;
        head = invert(head);
        head.prev = null;
        tail = headNode;
    }

    private Node invert(Node n) {
        Node invertedNode = null;
        Node currentNode = n;
        while (currentNode != null) {

            Node nextNode = currentNode.getNext();
            currentNode.setNext(invertedNode);
            invertedNode = currentNode;

            invertedNode.setPrev(nextNode);
            currentNode = nextNode;
        }
        return invertedNode;
    }

    /**
     * Deinitializes the object; think about it and comment what to do here.
     */
    protected void finalize() {
        /**
         * Method is deprecated -> the garbage collector automatically kills objects which have no reference anymore
         */
    }

    /**
     * Adds all elements from another list at the front of this linked list.
     */
    public void prepend(DoubleLinkedList other) {
        Node otherTail = other.tail;
        while(otherTail != null) {
            prepend(otherTail.val);
            otherTail = otherTail.prev;
        }
    }

    /**
     * Adds all elements from another list at the back of this linked list.
     */
    public void append(DoubleLinkedList other) {
        Node otherHead = other.head;
        while(otherHead != null) {
            append(otherHead.val);
            otherHead = otherHead.next;
        }
    }

    /** Clones this DoubleLinkedList instance and returns an exact COPY.*/
    public DoubleLinkedList clone() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.head = head;
        doubleLinkedList.tail = tail;
        doubleLinkedList.size = size;

        return doubleLinkedList;
    }

    /**
     * Returns true if the other list is equal to this one, false otherwise.
     * The contents of the two lists must not be changed!
     */
    public boolean equals(DoubleLinkedList other) {
        if(other.size != size) {
            return false;
        }

        Node otherHead = other.head;
        Node currentHead = head;

        while(otherHead != null) {
            if(otherHead.val != currentHead.val) {
                return false;
            }

            otherHead = otherHead.next;
            currentHead = currentHead.next;
        }

        return true;
    }

    /** Returns a string representation of the list. Example:
     * List of size 5: 1 -> 2 -> 3 -> 4 -> 5 */
    public String toString() {
        Node currentHead = head;
        String nodeString = currentHead.val+"";

        while(currentHead.next != null) {
            nodeString += "->" + currentHead.next.val;
            currentHead = currentHead.next;
        }

        return nodeString;
    }

    /** Returns true if the element val exists in the list, false otherwise.*/
    public boolean search(int val) {
        Node currentHead = head;

        while(currentHead != null) {
            if(currentHead.val == val) {
                return true;
            }
            currentHead = currentHead.next;
        }

        return false;
    }
}