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

//import java.lang.reflect.Array;

public class RandomizedArrayQueue<Item> implements Iterable<Item> {

    private int x = 0;

    private Item[] data;

    private int capacity = 8;
    /**
     *  // construct an empty randomized queue
     */
//    public RandomizedQueue(Class<Item> clazz) {
//        data = (Item[]) Array.newInstance(clazz, capacity);
//    }
    public RandomizedArrayQueue() {
    }
    /**
     *   is the randomized queue empty?
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return data.length == 0;
    }

    /**
     * @return number of item
     */
    public int size() {
        return data.length;
    }

    /**
     *  add the item
     * @param item item to add
     */
    public void enqueue(Item item){
        if (item == null) {
            throw new IllegalArgumentException();
        }
        data[x++] = item;
    }

    /**
     * // remove and return a random item
     * @return item
     */
    public Item dequeue() {
        if (data.length == 0) {
            throw new NoSuchElementException();
        }
        int r = StdRandom.uniform(0, data.length);
        Item item = data[r];
        for (int i = r; i < data.length; i++) {
            data[i] = data[i + 1];
        }
        x--;
        return item;
    }

    /**
     * // return a random item (but do not remove it)
     * @return item
     */
    public Item sample() {
        if (data.length == 0) {
            throw new NoSuchElementException();
        }
        return data[StdRandom.uniform(0, data.length)];
    }

    /**
     *  // return an independent iterator over items in random order
     * @return iterator of queue
     */
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < data.length;
            }

            @Override
            public Item next() {
                if (index >= data.length) {
                    throw new NoSuchElementException();
                }
                return data[index++];
            }
        };
    }

}
