package demo.algorithms.ch14.demo;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    // create an empty queue
    public Queue() {}
    // add an item
    public void enqueue(Item item) {}
    // remove the least recently added item
    public Item dequeue() {
        return null;
    }
    // is the queue empty?
    public boolean isEmpty() {
        return false;
    }
    // number of items in the queue
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
