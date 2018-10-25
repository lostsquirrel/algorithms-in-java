package demo.algorithms.searching;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayOrderedST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {

    private Entry[] data;

    private int size;
    private int capacity = 12;

    public ArrayOrderedST() {
        data = new Entry[capacity];
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Key min() {
        return (Key) data[0].key;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Key max() {
        return (Key) data[size - 1].key;
    }

    @Override
    public Key floor(Key key) {
        Entry datum = data[tryFind(key)];
        if (datum != null) {
            Key tk = (Key) datum.key;
            if (key.compareTo(tk) == 0) {
                return tk;
            }
        }

        return (Key) data[tryFind(key) - 1].key;
    }

    @Override
    public Key ceiling(Key key) {
        int i = tryFind(key);
        Entry datum = data[i];
        if (datum != null) {
            Key tk = (Key) datum.key;
            if (key.compareTo(tk) == 0) {
                return tk;
            }
        }
        return (Key) data[tryFind(key) + 1].key;
    }

    @Override
    public int rank(Key key) {
        return tryFind(key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Key select(int k) {
        return (Key) data[k].key;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void put(Key key, Value val) {
        resize();
        int x = size++;
        int i = x - 1;
        for (; i >= 0 ; i--) {
            if (key.compareTo((Key) data[i].key) < 0) {
                data[i + 1] = data[i];
            } else {
                break;
            }
        }
        data[i + 1] = new Entry(key, val);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Value get(Key key) {
        int index = find(key);
        Value v = null;
        if (index > -1) {
            v = (Value) data[index].value;
        }
        return v;
    }

    @Override
    public void delete(Key key) {
        int index = find(key);
        if (index > -1) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
        }
    }

    @Override
    public boolean contains(Key key) {
        return find(key) > -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        int index = 0;
        return new Iterable<Key>() {

            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    @Override
                    public boolean hasNext() {
                        return index < size;
                    }

                    @Override
                    @SuppressWarnings("unchecked")
                    public Key next() {
                        return (Key) data[index].key;
                    }
                };
            }
        };
    }

    /**
     * @param key key to find
     * @return index in array, -1 if not found
     */
    private int find(Key key) {
        int rank = tryFind(key);
        int index = -1;
        if (key.equals(data[rank].key)) {
            index = rank;
        }
        return index;
    }

    private int tryFind(Key key) {
        int lo = 0;
        int hi = size;
        return binarySearch(key, lo, hi);
    }

    @SuppressWarnings("unchecked")
    private int binarySearch(Key key, int lo, int hi) {
        if (lo >= hi) {
            return hi;
        }
        int mid = lo +  (hi - lo) / 2;
        Key mk = (Key) data[mid].key;
        if (key.compareTo(mk) > 0) {
            lo = mid + 1;
            return binarySearch(key, lo, hi);
        } else if (key.compareTo(mk) < 0) {
            hi = mid - 1;
            return binarySearch(key, lo, hi);
        } else {
            return mid;
        }

    }

    /**
     * double the array size;
     */
    private void resize() {
        if (size == capacity) {
            capacity = capacity << 1;
            Entry[] newData = new Entry[capacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    private class Entry<Key, Value> {
        Entry(Key key, Value val) {
            this.key = key;
            this.value = val;
        }

        private Key key;
        private Value value;

        @Override
        public String toString() {
            return "{" + key +
                    ": " + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
