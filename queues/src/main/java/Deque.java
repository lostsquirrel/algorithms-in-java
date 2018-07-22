/******************************************************************************
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P02
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Dequeue. A double-ended queue or deque (pronounced “deck”)
 *  is a generalization of a stack and a queue that supports adding
 *  and removing items from either the front or the back of the data structure
 *
 ******************************************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    /**
     * elements number in deque
     */
    private int size;

    /**
     * head of deque
     */
    private Node head;

    /**
     * tail of deque
     */
    private Node tail;

    /**
     *   construct an empty deque
     */
    public Deque() {

    }

    /**
     *  create and return iterator
     * @return an iterator over items in order from front to end
     */
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Node current =  head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }


    /**
     *    is the deque empty?
     * @return true if the deque empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *   number of items on the deque                      //
     * @return return the number of items on the deque
     */
    public int size() {
        return size;
    }

    /**
     *   add the item to the front
     * @param item item to add
     */
    public void addFirst(Item item) {
        validateAdd(item);
        Node n = new Node(item);
        if (head == null) {
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
        }
        head = n;
        size++;
    }

    /**
     *   add the item to the end
     * @param item item to add
     */
    public void addLast(Item item) {
        validateAdd(item);
        Node n = new Node(item);

        if (tail == null) {
            head = n;
        } else {
            n.prev = tail;
            tail.next = n;
        }
        tail = n;
        size++;
    }

    /**
     *  remove and return the item from the front
     * @return item
     */
    public Item removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Item n = head.item;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        size--;
        return n;
    }

    private void validateAdd(Item item) {
        if (item == null) {
            throw  new IllegalArgumentException("null");
        }
    }


    /**
     *  remove and return the item from the end
     * @return return
     */
    public Item removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        Item n = tail.item;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return n;
    }

    private class Node {
        Item item;
        Node prev;
        Node next;

        Node(Item item) {
            this.item = item;
        }

    }


}
