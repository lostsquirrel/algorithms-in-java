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
     *   is the randomized queue empty?
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
     *  add the item
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
            head.next = n;
        }
        size++;
    }

    /**
     * // remove and return a random item
     * @return item
     */
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int r = StdRandom.uniform(0, size);
        Node x1 = head;
        for (int i = 1; i < r - 1; i++) {
            x1 = x1.next;
        }
        size--;
        Node x2 = x1.next;
        x1.next = x2.next;
        return x2.item;
    }

    /**
     * // return a random item (but do not remove it)
     * @return item
     */
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int r = StdRandom.uniform(0, size);
        Node x = head;
        for (int i = 0; i < r - 2; i += 2) {
            head = head.next.next;
        }
        return x.item;
    }

    /**
     *  // return an independent iterator over items in random order
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
