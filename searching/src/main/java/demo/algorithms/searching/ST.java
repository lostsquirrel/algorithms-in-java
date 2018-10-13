package demo.algorithms.searching;

/**
 * @param <Key>
 * @param <Value>
 *     The symbol table is a prototypical abstract data type (see Chapter 1):
 *     it represents a well-defined set of values and operations on those values,
 *     enabling us to develop
clients and implementations separately.
 */
public interface ST<Key, Value> {

    /**
     put key-value pair into the table (remove key from table if value is null)
     */
    void put(Key key, Value val);
    /**
     value paired with key (null if key is absent)
     */
    Value get(Key key);

    /**
     remove key (and its value) from table
     */
    void delete(Key key);
    /**
     is there a value paired with key?
     */
    boolean contains(Key key);
    /**
     is the table empty?
     */
    boolean isEmpty();
    /**
     number of key-value pairs in the table
     */
    int size();
    /**
     all the keys in the table
     */
    Iterable<Key> keys();
}
