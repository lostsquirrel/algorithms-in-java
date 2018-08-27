package demo.algorithms.ch01.demo;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    //create an empty bag
    public Bag() {

    }
    //add an item
    public void add(Item item) {

    }
    //is the bag empty?
    public boolean isEmpty() {
        return false;
    }
    //number of items in the bag
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
