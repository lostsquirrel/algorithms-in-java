package demo.algorithms.priority;

public interface MaxPQ< Key extends Comparable<Key>> {


    /**
     * insert a key into the priority queue
     * @param v a key into the priority queue
     */
    void insert(Key v);

    /**
     * return the largest key
     * @return the largest key
     */
    Key max();

    /**
     * return and remove the largest key
     * @return the largest key
     */
    Key delMax();

    /**
     * is the priority queue empty?
     * @return true if it is empty, otherwise false
     */
    boolean isEmpty();

    /**
     * number of keys in the priority queue
     * @return number of keys
     */
    int size();
}
