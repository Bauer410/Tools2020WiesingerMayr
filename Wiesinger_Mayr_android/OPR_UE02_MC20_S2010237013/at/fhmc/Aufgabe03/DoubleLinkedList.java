package at.fhmc.Aufgabe03;

public class DoubleLinkedList {
    /** Pointer to the first and last element of the list */
    private Node head, tail;
    private int size;

    /** Also pointer to the first and last element of the list,
     * but holding Nodes capable of storing additional lists. */
    private ListNode recursiveHead, recursiveTail;

    //region Getter and Setter
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public ListNode getRecursiveHead() {
        return recursiveHead;
    }

    public void setRecursiveHead(ListNode recursiveHead) {
        this.recursiveHead = recursiveHead;
    }

    public ListNode getRecursiveTail() {
        return recursiveTail;
    }

    public void setRecursiveTail(ListNode recursiveTail) {
        this.recursiveTail = recursiveTail;
    }
    //endregion

    public DoubleLinkedList() {
        head = null;
        tail = null;
        recursiveHead = null;
        recursiveTail = null;
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
        recursiveTail = null;
        recursiveHead = null;
        size = 0;
    }

    /** Adds an element at the front of the linked list.*/
    public void prepend(int val) {
        if((recursiveHead != null || recursiveTail != null) && size != 0) {
            return;
        }

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
        if((recursiveHead != null || recursiveTail != null) && size != 0) {
            return;
        }

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

    /** Returns the number of elements in the double linked list */
    public int size() {
        return size;
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
            size++;
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
            size++;
        }
    }

    /** Clones this DoubleLinkedList instance and returns an exact COPY.*/
    public DoubleLinkedList clone() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.head = head;
        doubleLinkedList.tail = tail;

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

    /** Adds another list at the beginning of this linked list.
     * Only works while head and tail are null. Uses recursiveHead
     * internally.  */
    public void prependRecursive(DoubleLinkedList list) {
        // an empty list cannot be added
        if((head != null || tail != null) && list.size != 0) {
            return;
        }

        if(recursiveHead == null) {
            recursiveHead = new ListNode();
            recursiveHead.list = list;
            recursiveTail = recursiveHead;
        } else {
            ListNode headNode = recursiveHead;
            recursiveHead = new ListNode();

            headNode.prev = recursiveHead;
            recursiveHead.next = headNode;
            recursiveHead.list = list;
        }

        size++;
    }

    /** Adds another list at the end of this linked list.
     * Only works while head and tail are null. Uses recursiveTail
     * internally. */
    public void appendRecursive(DoubleLinkedList list) {
        // an empty list cannot be added
        if((head != null || tail != null) && list.size != 0) {
            return;
        }

        if(recursiveTail == null) {
            recursiveTail = new ListNode();
            recursiveTail.list = list;
            recursiveHead = recursiveTail;
        } else {
            ListNode tailNode = recursiveTail;
            recursiveTail = new ListNode();

            tailNode.next = recursiveTail;
            recursiveTail.prev = tailNode;
            recursiveHead.list = list;
        }

        size++;
    }

    /** Removes and returns the front element of the linked list, or if
     * the first element is another list, returns that list’s first
     * element. Returns Integer.MIN_VALUE if empty. */
    public int popFront() {
        if(size == 0) {
            return Integer.MIN_VALUE;
        }

        int value = 0;

        // check if value list
        if(head != null) {
            Node node = head;
            head = node.next;
            size--;

            value = node.val;
        } else if(recursiveHead != null) {
            value = getFirstValueOfList(recursiveHead, true);
        }


        return value;
    }



    /** Returns the front element of the list without removing it. If the
     * first element is another list, returns that list’s first element.
     * Returns Integer.MIN_VALUE if empty. */
    public int peekFront() {
        if(size == 0) {
            return Integer.MIN_VALUE;
        }

        if(head != null) {
            return head.val;
        }

        return getFirstValueOfListWithOutRemoving(recursiveHead, true);
    }



    /** Removes and returns the element from the back of the linked list,
     * or if the last element is another list, returns that list’s last
     * element. Returns Integer.MIN_VALUE if empty. */
    public int popBack() {
        if(size == 0) {
            return Integer.MIN_VALUE;
        }

        int value = 0;

        // check if value list
        if(tail != null) {
            Node node = tail;
            tail = node.prev;
            size--;

            value = node.val;
        } else {
            value = getFirstValueOfList(recursiveTail, false);
        }

        if(size == 0) {
            clear();
        }
        return value;
    }

    /** Returns the element at the back of the list without removing it.
     * If the last element is another list, returns that list’s last
     * element. Returns Integer.MIN_VALUE if empty. */
    public int peekBack() {
        if(size == 0) {
            return Integer.MIN_VALUE;
        }

        if(tail != null) {
            return tail.val;
        }

        return getFirstValueOfListWithOutRemoving(recursiveTail, false);
    }

    /** Returns the number of elements in the double linked list and of
     * all its sub-lists. */
    public int elements() {
        int number = size;

        if(head == null) {
            ListNode headNode = recursiveHead;

            while(headNode != null) {
                number += headNode.list.size;
                headNode = headNode.next;
            }
        }

        return number;
    }

    /** Reverse the order of all elements. Does NOT change the order of
     * sub-lists! */
    public void reverse() {
        Node headNode = head;
        head = invert(head);
        head.prev = null;
        tail = headNode;
    }

    /**
     * Returns true if the element val exists in the list or in any of
     * its sub-lists, false otherwise. */
    public boolean search(int val) {
        if(head != null) {
            if(searchThroughList(this, val)) {
                return true;
            }
        } else {
            ListNode headNode = recursiveHead;

            while(headNode != null) {
                if(searchThroughList(headNode.list, val)) {
                    return true;
                }
                headNode = headNode.next;
            }
        }
        return false;
    }

    private boolean searchThroughList(DoubleLinkedList list, int val) {
        Node headNode = list.head;
        while(headNode != null) {
            if(headNode.val == val) {
                return true;
            }
            headNode = headNode.next;
        }
        return false;
    }

    private int getFirstValueOfList(ListNode recursiveListNode, boolean isFront) {
        DoubleLinkedList list = recursiveListNode.list;
        Node node = list.head;

        // check whether this method is called from a front or back-method
        if(isFront) {
            // if the head of the list is null it means that there is a list in a list -> call method recusrive
            if(list.head == null) {
                getFirstValueOfList(list.recursiveHead, true);
            }

            // if there is a head -> finally remove value
            node = list.head;
            list.head = node.next;
        } else {
            if(list.tail == null) {
                getFirstValueOfList(list.recursiveTail, false);
            }

            node = list.tail;
            list.tail = node.prev;
        }

        list.size--;

        // if the size of the list is 0, the current listNode should be deleted
        if(list.size == 0 && recursiveListNode.next == null && recursiveListNode.prev == null) {
            clear();
        }
        else if(list.size == 0 && recursiveListNode.next == null) { // if the recursiveListNode does not have a next it means that it is the tail
            recursiveTail = recursiveTail.prev;
            recursiveTail.next = null;

            size--;
        }
        else if(list.size == 0 && recursiveListNode.prev == null) { // if the recursiveListNode does not have a prev it means that it is the head
            recursiveHead = recursiveHead.next;
            recursiveHead.prev = null;

            size--;
        }

        return node.val;
    }

    // makes exactly the same as the method before but does not remove the value, just returns it
    private int getFirstValueOfListWithOutRemoving(ListNode recursiveListNode, boolean isFront) {
        if(recursiveListNode.list.size == 0) {
            return Integer.MIN_VALUE;
        }

        DoubleLinkedList list = recursiveListNode.list;

        Node node = list.head;
        if(isFront) {
            if(list.head == null) {
                getFirstValueOfListWithOutRemoving(list.recursiveHead, true);
            }
        } else {
            if(list.tail == null) {
                getFirstValueOfListWithOutRemoving(list.recursiveTail, false);
            }
            node = list.tail;
        }

        return node.val;
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
}

