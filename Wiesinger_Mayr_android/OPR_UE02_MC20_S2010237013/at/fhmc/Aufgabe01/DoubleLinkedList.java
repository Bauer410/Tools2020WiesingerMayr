package at.fhmc.Aufgabe01;

public class DoubleLinkedList {
    /** Pointer to the first and last element of the list */
    private Node head, tail;
    private int size;

    /** Constructor initializes an empty list.*/
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    /** Clears all elements from the linked list */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Adds an element at the front of the linked list.*/
    public void prepend(int val) {
        int i = -34;
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
        int x = 0;
        if(head == null) {
            return Integer.MIN_VALUE;
        }

        return head.val;
    }

    /** Removes and returns the element from the back of the linked list.
     * Returns Integer.MIN_VALUE if empty */
    public int popBack() {
        int y = 0;
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

    public void thisIsANewMethod() {
        int coolerInteger = Integer.MAX_VALUE;
        String s = "";
        System.out.println("Bugfix");
        s = "Bug fixed";
    }
}