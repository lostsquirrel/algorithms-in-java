/******************************************************************************
 *  Name:    Song Li
 *  NetID:   lostsquirreli@hotmail.com
 *  Precept: P02
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  A randomized queue is similar to a stack or queue,
 *  except that the item removed is chosen uniformly
 *  at random from items in the data structure
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    /**
     * elements number in deque
     */
    private int size;

    /**
     * head of deque
     */
    private Node head;

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
    }

    /**
     * is the randomized queue empty?
     *
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return number of item
     */
    public int size() {
        return size;
    }

    /**
     * add the item
     *
     * @param item item to add
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node n = new Node(item);
        if (head == null) {
            head = n;
        } else {
            Node x = head;
            while (x.next != null) {
                x = x.next;
            }
            x.next = n;
        }
        size++;
    }

    /**
     * // remove and return a random item
     *
     * @return item
     */
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item item;
        if (size == 1) {
            size--;
            item = head.item;
            head = null;
            return item;
        }
        int r = StdRandom.uniform(0, size);


        if (r == 0) {
            item = head.item;
            head = head.next;
        } else {
            Node x1 = get(r - 1);
            item = x1.next.item;
            x1.next = x1.next.next;
        }
        size--;
        return item;
    }

    /**
     * // return a random item (but do not remove it)
     *
     * @return item
     */
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int r = StdRandom.uniform(0, size);
        Node x = get(r);
        return x.item;
    }

    private Node get(int index) {

        Node x = head;
        while (index > 0) {
            x = x.next;
            index--;
        }
        return x;
    }

    /**
     * // return an independent iterator over items in random order
     *
     * @return iterator of queue
     */
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                Node n = current;
                current = current.next;
                return n.item;
            }
        };
    }

    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }

    }
}
