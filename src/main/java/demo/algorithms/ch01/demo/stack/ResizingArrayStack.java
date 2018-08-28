package demo.algorithms.ch01.demo.stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;
    private int DEFAULT_CAPACITY = 12;

    // create an empty stack
    public ResizingArrayStack() {
        a = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    // add an item
    public void push(Item item) {
        // Add item to top of stack.
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    // remove the most recently added item
    public Item pop() {
        // Remove item from top of stack.
        Item item = a[--N];
        a[N] = null; // Avoid loitering (see text).
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    // is the stack empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // number of items in the stack
    public int size() {
        return N;
    }

    private void resize(int max) { // Move stack of size N <= max to a new array of size max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[--i]; }
        public void remove() { }
    }
}
