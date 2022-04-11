// Name:		Dora Avun
// Program Number: (#1) MyLinkedListDoraAvun
// IDE: 		IntelliJ IDEA (2021.3.1)
// Implement a linked list and utility functions in java.

public class MyLinkedListDoraAvun<T>
{
    Node head;
    Node tail;
    int size;

    public class Node
    {
        T data;
        Node link;
        Node()
        {
        }
        Node(T element)
        {
            data = element;
            link = null;
        }
    }

    MyLinkedListDoraAvun()
    {
        head = null;
        tail = null;
        size = 0;

    }

    public T getFirst() throws RuntimeException
    {
        if(head.link == null) //if no head element, list is empty, runtime exception.
        {
            throw new RuntimeException("List is empty");
        }
        else
            return head.data; //return head element
    }
    public T getLast() throws RuntimeException {

        if (tail == null)
        { //if tail is null, error
            throw new RuntimeException("List is empty");
        }
        else //if not, return tail
            return tail.data;

    }
    public void addLast(T newElement)
    {
        Node newNode = new Node(newElement);
        if (size == 0) //if size is 0, new added node is head.
        {
            head = newNode;
        }
        else
        {
            newNode.link = null; //link of newNode is null
            Node tailCount = head; //create node from head
            while (tailCount.link != null) //parse through the end of the list
            {
                tailCount = tailCount.link;
            }
            tailCount.link = newNode; //put the newNode to the last link
        }
        size++; //increment size
    }

    public void removeLast()
    {
        if(head == null)//if no elements, error runtime
        {
            throw new RuntimeException("in removeFirst(): no elements in the list");
        }
        else if(head == tail) { // if only 1 elements, both are null
            head = tail = null;
            size --;
        }
        else
        {
            Node tailCount = head;
            while (tailCount.link != tail) //count from head until one before tail
            {
                tailCount = tailCount.link;
            }

            tail = tailCount; //new tail is tailCount.
            tailCount.link = null; //tail is null

            size--;
        }
    }

    public int indexOf(T targetElement){
        // search the targetElement in the list, return the index of given targetElement if it exists.
        // if the list doesn't have targetElement, return -1
        // Caution: index starts with 0  (the first element's index is 0)
        // Caution: to return index, you must check the index of node while you searching
        // Write code here
        return 3;
    }
    public Iterator iterator(){
        return new Iterator();
    }

    // Complete the Iterator class
    class Iterator {
        Node next; // to point [next node] object

        Iterator(){
            // next must be the first node of the list
            next = head;
        }

        public T next(){
            // return the data_field of [next node]
            T data_field = next.data;
            next = next.link;
            return data_field;
        }
        public boolean hasNext(){
            // return true when the [next node] exists
            // return false when we don't have the [next node]
            if (next != null) {
                return true;
            }
            return false;
        }

    }

    public void removeFirst() throws RuntimeException {
        if(head == null) {
            throw new RuntimeException("in removeFirst(): no elements in the list");
        }
        else if(head == tail) { // if(size==1)
            head = tail = null;
            size --;
        }
        else {
            head = head.link;
            size--;
        }

    }
    public void remove(int index) {
        if(index == 0) {
            removeFirst();
        }
        else if(head == tail) {
            head = tail = null;
            size--;
        }
        else {
            Node cur = head;
            while (--index > 0) {
                cur = cur.link;
            }
            Node targetNode = cur.link;
            cur.link = targetNode.link;
            size--;
            if(cur.link == null)
                tail = cur;
        }
    }

    public void addFirst(T newElement){
        Node newNode = new Node(newElement);
        newNode.link = head;
        head = newNode;
        if(size==0) {
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T newElement) {
        if(index == 0)
            addFirst(newElement);
        else {
            Node temp1 = head;
            while (--index > 0) {
                temp1 = temp1.link;
            }
            Node newNode = new Node(newElement);
            newNode.link = temp1.link;
            temp1.link = newNode;

            if (newNode.link == null) {
                tail = newNode;
            }
            size++;
        }
    }

    public String toString() {
        String str = "[";
        Node temp = head;

        while(temp != null) {
            str = str + temp.data;
            if(temp != tail) {
                str = str + ", ";
            }
            temp = temp.link;
        }
        return str = str + "]";
    }

}
